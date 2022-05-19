class Solution {
    public int longestIncreasingPath(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        int dp[][]=new int[r][c];
        for(int x[]:dp) Arrays.fill(x,-1);
        
        int res=1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res=Math.max(res,solver(mat,i,j,dp));
            }
        }
        
        return res;
    }
    
    public int solver(int mat[][],int i,int j,int dp[][]){
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        dp[i][j]=1;
        
        for(int k=0;k<4;k++){
            int newx=i+offset[k][0];
            int newy=j+offset[k][1];
            
            if(newx<0||newy<0||newx>=mat.length||newy>=mat[0].length||
               mat[newx][newy]<=mat[i][j]) continue;
            
            dp[i][j]=Math.max(dp[i][j],1+solver(mat,newx,newy,dp));
        }
        
        return dp[i][j];
    }
    
    public int offset[][]={
        {-1,0},
        {1,0},
        {0,1},
        {0,-1}
    };
}