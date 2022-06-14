class Solution {
    public int getFood(char[][] grid) {
        int sx=-1;int sy=-1;
        for(int i=0;i<grid.length;i++){
            boolean found=false;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='*'){
                    found=true;
                    sx=i;sy=j;
                    break;
                }
            }
            if(found) break;
        }
        
        if(sx==-1&&sy==-1) return -1;
        
        return bfs(grid,sx,sy);
    }
    
    public int bfs(char grid[][],int sx,int sy){
        int r=grid.length;int c=grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sx,sy,0,0});//{x,y,dist,food cell or not-1/0}
        grid[sx][sy]='.';
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int x=curr[0];int y=curr[1];int dist=curr[2];int isFoodCell=curr[3];
                if(isFoodCell==1) return dist;
                for(int j=0;j<4;j++){
                    int newx=x+offset[j][0];
                    int newy=y+offset[j][1];
                    if(newx<0||newx>=r||newy<0||newy>=c
                      ||grid[newx][newy]=='.'||grid[newx][newy]=='X') continue;
                    
                    int foodCell=(grid[newx][newy]=='#')?1:0;
                    
                    grid[newx][newy]='.';
                    
                    q.add(new int[]{newx,newy,dist+1,foodCell});
                }
            }
        }
        
        return -1;
    }
    
    public int offset[][]={
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
}