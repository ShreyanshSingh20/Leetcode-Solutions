class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String,PriorityQueue<String>> map=new HashMap<>();
        
        int n=tickets.size();
        for(int i=0;i<n;i++){
            String src=tickets.get(i).get(0);
            String dest=tickets.get(i).get(1);
            map.putIfAbsent(src,new PriorityQueue<>());
            map.get(src).add(dest);
        }
        
        List<String> list=new ArrayList<>();
        dfs(map,list,"JFK");
        
        Collections.reverse(list);
        List<String> res=new ArrayList<>();
        
        res.add(list.get(0));
        
        for(int i=1;i<list.size();i+=2){
            res.add(list.get(i));
        }
        return res;
    }
    
    public void dfs(HashMap<String,PriorityQueue<String>> map,List<String> res,String node){
        PriorityQueue<String> pq=map.get(node);
        if(pq!=null){
            while(!pq.isEmpty()){
                String curr=pq.poll();
                dfs(map,res,curr);
                res.add(curr);
                res.add(node);
            }
        }
    }
}