class Solution {
    public int maxAreaOfIsland(int[][] mat) {
        
        int r=mat.length;
        int c=mat[0].length;
        
        int res=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==1){
                    res=Math.max(res,dfs(i,j,mat));
                }
            }
        }
        
        return res;
    }
    
    public int dfs(int i,int j,int mat[][]){
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||mat[i][j]==0) return 0;
        mat[i][j]=0;
        int res=1;
        for(int k=0;k<4;k++){
            int newx=i+off[k][0];
            int newy=j+off[k][1];
            res+=dfs(newx,newy,mat);
        }
        return res;
    }
    
    public int off[][]={
        {0,1},{1,0},{-1,0},{0,-1}
    };
}