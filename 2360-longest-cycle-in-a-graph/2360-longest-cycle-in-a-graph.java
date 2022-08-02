class Solution {
    public int longestCycle(int[] edges) {
        
        int n=edges.length;
    
        List<List<Integer>> g=new ArrayList<>();
        List<List<Integer>> transpose=new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int i=0;i<n;i++) transpose.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            if(edges[i]==-1) continue;
            g.get(i).add(edges[i]);
            transpose.get(edges[i]).add(i);
        }
        
        Stack<Integer> s=new Stack<>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]) fillStack(g,i,s,n,vis);
        }        
        List<List<Integer>> scc=new ArrayList<>();
        Arrays.fill(vis,false);
        while(!s.isEmpty()){
            int src=s.pop();
            if(vis[src]) continue;
            List<Integer> currList=new ArrayList<>();
            dfs(transpose,src,vis,currList);
            scc.add(new ArrayList<Integer>(currList));
        }
        
        int res=-1;
        for(int i=0;i<scc.size();i++){
            if(scc.get(i).size()>1) res=Math.max(scc.get(i).size(),res);
        }
        
        return res;
    }
    
    public void fillStack(List<List<Integer>> g,int source,Stack<Integer> s,int n,boolean vis[]){
        vis[source]=true;
        for(int x:g.get(source)){
            if(!vis[x]){
                fillStack(g,x,s,n,vis);
            }
        }
        s.push(source);
    }
    
    public void dfs(List<List<Integer>> g,int src,boolean vis[],List<Integer> currList){
        vis[src]=true;
        currList.add(src);
        
        for(int x:g.get(src)){
            if(!vis[x]){
                dfs(g,x,vis,currList);
            }
        }
        
    }
}