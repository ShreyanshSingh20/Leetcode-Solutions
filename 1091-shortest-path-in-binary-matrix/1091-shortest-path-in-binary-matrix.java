class Solution {
    public int shortestPathBinaryMatrix(int[][] mat) {
        if(mat[0][0]==1) return -1;
        int n=mat.length;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        mat[0][0]=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curr[]=queue.poll();
                int x=curr[0];int y=curr[1];int dist=curr[2];
                if(x==n-1&&y==n-1) return dist;
                for(int j=0;j<offset.length;j++){
                    int newx=x+offset[j][0];
                    int newy=y+offset[j][1];
                    if(newx<0||newy<0||newx>=n||newy>=n||mat[newx][newy]==1) continue;
                    queue.add(new int[]{newx,newy,dist+1});
                    mat[newx][newy]=1;
                }
            }
        }
        
        return -1;
    }
    
    public int offset[][]={
        {-1,-1},
        {-1,0},
        {-1,1},
        {0,-1},
        {0,1},
        {1,-1},
        {1,0},
        {1,1}
    };
}