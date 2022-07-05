class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        int n=pid.size();
        
        HashMap<Integer,List<Integer>> g=new HashMap<>();
        
        HashMap<Integer,Integer> indeg=new HashMap<>();
        
        for(int i=0;i<n;i++){
            int u=ppid.get(i);
            int v=pid.get(i);
            if(u==0) continue;
            indeg.put(v,indeg.getOrDefault(v,0)+1);
            addEdge(g,u,v);
        }
        
        Queue<Integer> queue=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        queue.add(kill);
        if(indeg.containsKey(kill)){
            int freq=indeg.get(kill);
            if(freq==1) indeg.remove(kill);
            else indeg.put(kill,freq-1);
        }
        
        while(!queue.isEmpty()){
            int curr=queue.poll();
            res.add(curr);
            if(!g.containsKey(curr)) continue;
            for(Integer x:g.get(curr)){
                if(indeg.containsKey(x)){
                    int freq=indeg.get(x);
                    if(freq==1) indeg.remove(x);
                    else indeg.put(x,freq-1);
                }
                if(!indeg.containsKey(x)) queue.add(x);
            }
        }
        
        return res;
    }
    
    public void addEdge(HashMap<Integer,List<Integer>> g,int u,int v){
        g.putIfAbsent(u,new ArrayList<Integer>());
        g.get(u).add(v);
    }
}