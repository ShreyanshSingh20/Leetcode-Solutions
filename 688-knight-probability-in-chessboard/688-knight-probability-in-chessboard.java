class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        Double dp[][][]=new Double[n+1][n+1][k+1];
        return solver(row,column,k,n,dp);
    }
    
    public double solver(int i,int j,int k,int n,Double dp[][][]){
        if(i<0||j<0||i>=n||j>=n) return 0;
        
        if(dp[i][j][k]!=null) return dp[i][j][k];
        
        if(k==0) return 1.0;
        double res=0.0;
        for(int x=0;x<8;x++){
            res+=(0.125)*(solver(i+offset[x][0],j+offset[x][1],k-1,n,dp));
        }
        return dp[i][j][k]=res;
    }
    
    public int offset[][]={
        {-2,1},{-1,2},{-2,-1},{-1,-2},
        {1,2},{2,1},{1,-2},{2,-1}
    };
}