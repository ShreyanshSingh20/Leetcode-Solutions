class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            g.add(new ArrayList<Integer>());
        }
        
        int indeg[]=new int[numCourses];
        for(int i=0;i<pre.length;i++){
            int u=pre[i][0];
            int v=pre[i][1];
            indeg[u]++;
            addEdge(g,v,u);
        }
        
        return bfs(g,indeg,numCourses);
        
    }
    
    public boolean bfs(List<List<Integer>> g,int indeg[],int n){
        
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        
        int cnt=0;//the number of courses completed
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int currNode=q.poll();
                cnt++;
                for(int x:g.get(currNode)){
                    indeg[x]--;
                    if(indeg[x]==0){
                        q.add(x);
                    }
                }
            }
        }
        
        if(cnt==n) return true;
        return false;
    }
    
    
    
    public void addEdge(List<List<Integer>> g,int u,int v){
        g.get(u).add(v);
    }
}
