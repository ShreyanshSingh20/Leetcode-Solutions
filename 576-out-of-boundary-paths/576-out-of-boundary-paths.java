class Solution {
    long mod=1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long dp[][][]=new long[51][51][51];
        for(long x[][]:dp){
            for(long y[]:x){
                Arrays.fill(y,-1);
            }
        }
        return (int)dfs(startRow,startColumn,maxMove,m,n,dp);
    }
    
    public long dfs(int i,int j,int maxMove,int r,int c,long dp[][][]){
        if(i<0||i>=r||j<0||j>=c) return 1;
        if(maxMove<=0) return 0;
        
        if(dp[i][j][maxMove]!=-1) return dp[i][j][maxMove];
        
        long res=0;
        for(int k=0;k<4;k++){
            int newx=i+offset[k][0];
            int newy=j+offset[k][1];
            res=add(res,dfs(newx,newy,maxMove-1,r,c,dp));
        }
        return dp[i][j][maxMove]=res;
    }
    
    public long add(long x,long y){
        x+=y;
        if(x>=mod) return x%mod;
        return x;
    }
    
    public int offset[][]={
        {0,1},{1,0},{-1,0},{0,-1}
    };
}