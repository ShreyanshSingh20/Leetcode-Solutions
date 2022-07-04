class Solution {
    public long mod=1_000_000_007;
    public int countPaths(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        long res=0;
        Long dp[][]=new Long[r+1][c+1];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res=add(res,dfs(i,j,mat,-1,dp));
            }
        }
        
        return (int)res;
    }
    
    public long dfs(int i,int j,int mat[][],int prev,Long dp[][]){
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||mat[i][j]<=prev) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        long res=0;
        for(int k=0;k<4;k++){
            res=add(res,dfs(i+offset[k][0],j+offset[k][1],mat,mat[i][j],dp));
        }
        return dp[i][j]=add(1,res);
    }
    
    public int offset[][]={
        {0,1},{1,0},{-1,0},{0,-1}
    };
    
    public long add(long x,long y){
        x+=y;
        if(x>=mod) return x%mod;
        return x;
    }
}