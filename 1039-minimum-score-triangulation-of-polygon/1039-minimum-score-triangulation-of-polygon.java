class Solution {
    public int minScoreTriangulation(int[] values) {
        
        int n=values.length;
        Integer dp[][]=new Integer[n+1][n+1];
        return solver(values,0,n-1,dp);
    }
    
    public int solver(int arr[],int i,int j,Integer dp[][]){
        
        if(j-i<2) return 0;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        int res=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            res=Math.min(res,solver(arr,i,k,dp)+(arr[i]*arr[j]*arr[k])+solver(arr,k,j,dp));
        }
        
        return dp[i][j]=res;
    }
}