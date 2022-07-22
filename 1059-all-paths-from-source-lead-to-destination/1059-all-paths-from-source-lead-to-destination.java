class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        List<HashSet<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new HashSet<>());
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            addEdge(g,u,v);
        }
        
        boolean vis[]=new boolean[n];
        return dfs(g,source,destination,vis);
        
    }
    
    public boolean dfs(List<HashSet<Integer>> g,int source,int destination,boolean vis[]){
        vis[source]=true;
        Iterator e=g.get(source).iterator();
        boolean andarGhusa=false;
        while(e.hasNext()){
            //I have outgoing edges from the destination and according to rules my destination
            //cannot have outgoing edges
            if(source==destination) return false;
            int next=(int)e.next();
            if(vis[next]) return false;
            if(!dfs(g,next,destination,vis)) return false;
            andarGhusa=true;
        }
        vis[source]=false;
        if(source!=destination){
            if(andarGhusa) return true;
            else return false;
        }
        if(source==destination) return true;
        return false;
    }
    
    public void addEdge(List<HashSet<Integer>> g,int u,int v){
        g.get(u).add(v);
    }
}