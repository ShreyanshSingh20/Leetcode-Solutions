class Solution {
    public int snakesAndLadders(int[][] mat) {
        
        int n=mat.length;
        
        //first step is to map the cells with their respective snakes
        //and ladders, this is done to solve the problem with ease of access
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int num=n*n;int turn=(n%2==0?0:1);
        for(int i=0;i<n;i++){
            
            if(turn%2==0){
                for(int j=0;j<n;j++){
                    if(mat[i][j]!=-1){
                        map.put(num,mat[i][j]);
                    }
                    num--;
                }
            }else{
                for(int j=n-1;j>=0;j--){
                    if(mat[i][j]!=-1){
                        map.put(num,mat[i][j]);
                    }
                    num--;
                }
            }
            
            turn++;
        }
        
        return bfs(map,n);
       
    }
    
    public int bfs(HashMap<Integer,Integer> map,int n){
        
        HashSet<Integer> vis=new HashSet<>();
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        q.add(new int[]{1,0});
        vis.add(1);
        
        while(!q.isEmpty()){
            
            int curr[]=q.poll();
            int currPos=curr[0];int dist=curr[1];
            
            if(currPos==n*n) return dist;
            
            for(int next=currPos+1;next<=Math.min(n*n,currPos+6);next++){
                
                if(vis.contains(next)) continue;
                
                vis.add(next);
                
                if(map.containsKey(next)){
                    int finalPos=map.get(next);
                    q.add(new int[]{finalPos,dist+1});
                }else{
                    vis.add(next);
                    q.add(new int[]{next,dist+1});
                }
            }
            
        }
        
        return -1;
    }
}