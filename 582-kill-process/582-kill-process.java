class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        int n=pid.size();
        
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<=50005;i++) g.add(new ArrayList<Integer>());
        
        int indeg[]=new int[50005];
        
        for(int i=0;i<n;i++){
            int u=ppid.get(i);
            int v=pid.get(i);
            if(u==0) continue;
            indeg[v]++;
            addEdge(g,u,v);
        }
        
        Queue<Integer> queue=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        queue.add(kill);
        indeg[kill]--;
        
        while(!queue.isEmpty()){
            int curr=queue.poll();
            res.add(curr);
            for(int x:g.get(curr)){
                // System.out.println(x);
                indeg[x]--;
                if(indeg[x]==0) queue.add(x);
            }
        }
        
        return res;
    }
    
    public void addEdge(List<List<Integer>> g,int u,int v){
        g.get(u).add(v);
    }
}