class Solution {
    public int maximumScore(int arr[], int[][] edges) {
        int n=arr.length;
        PriorityQueue<Integer>[] q=new PriorityQueue[n];
        for(int i=0;i<n;i++){
            q[i]=new PriorityQueue<Integer>((a,b)->arr[a]-arr[b]);
        }
        
        int e=edges.length;
        for(int i=0;i<e;i++){
            int u=edges[i][0];int v=edges[i][1];
            q[u].add(v);
            q[v].add(u);
            
            if(q[u].size()>3) q[u].poll();
            if(q[v].size()>3) q[v].poll();
        }
        
        int res=-1;
        for(int edge[]:edges){
            for(int i:q[edge[0]]){
                for(int j:q[edge[1]]){
                    if(i!=j&&i!=edge[1]&&j!=edge[0]){
                        res=Math.max(res,arr[edge[0]]+arr[edge[1]]+arr[i]+arr[j]);
                    }
                }
            }
        }
        
        return res;
    }
    
}