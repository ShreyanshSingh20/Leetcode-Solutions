class Solution {
    
    public List<List<Integer>> res=new ArrayList<>();
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        
        for(int i=0;i<connections.size();i++){
            addEdge(g,connections.get(i).get(0),connections.get(i).get(1));
        }
        
        int inTime[]=new int[n];
        int lowTime[]=new int[n];
        boolean vis[]=new boolean[n];
        dfs(g,0,-1,inTime,lowTime,vis);
        return res;
    }
    
    public void addEdge(List<List<Integer>> g,int u,int v){
        g.get(u).add(v);
        g.get(v).add(u);
    }
    
    public int timer=0;
    
    public void dfs(List<List<Integer>> g,int node,int par,int inTime[],int lowTime[],boolean vis[]){
        
        timer++;
        inTime[node]=timer;
        lowTime[node]=timer;
        vis[node]=true;
        
        for(int adjNode:g.get(node)){
            if(adjNode==par) continue;
            if(!vis[adjNode]){
                dfs(g,adjNode,node,inTime,lowTime,vis);
                lowTime[node]=Math.min(lowTime[node],lowTime[adjNode]);
                if(lowTime[adjNode]>inTime[node]){
                    List<Integer> sub=new ArrayList<>();
                    sub.add(node);sub.add(adjNode);
                    res.add(new ArrayList<>(sub));
                }
            }else{
                lowTime[node]=Math.min(lowTime[node],lowTime[adjNode]);
            }
        }
    }
}