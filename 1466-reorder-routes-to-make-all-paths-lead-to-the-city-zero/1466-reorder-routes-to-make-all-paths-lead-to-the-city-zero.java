class Solution {
    public int minReorder(int n, int[][] mat) {
        
        List<HashSet<Integer>> og=new ArrayList<>();
        List<List<Integer>> ug=new ArrayList<>();
        for(int i=0;i<n;i++){
            og.add(new HashSet<>());
            ug.add(new ArrayList<>());
        }
        
        int e=mat.length;
        for(int i=0;i<e;i++){
            int u=mat[i][0];int v=mat[i][1];
            og.get(u).add(v);
            ug.get(u).add(v);
            ug.get(v).add(u);
        }
        
        return bfs(og,ug,n);
        
    }
    
    public int bfs(List<HashSet<Integer>> og,List<List<Integer>> ug,int n){
        Queue<Integer> q=new ArrayDeque<>();
        HashSet<Integer> vis=new HashSet<>();
        q.add(0);
        vis.add(0);
        
        int res=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int next:ug.get(curr)){
                if(vis.contains(next)) continue;
                if(og.get(curr).contains(next)) res++;
                q.add(next);
                vis.add(next);
            }
        }
        
        return res;
    }
    
    
}