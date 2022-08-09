class Solution {
    public int racecar(int target) {
        
        int dp[]=new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        return solver(target,dp);
    }
    
    public int solver(int i,int dp[]){
        
        if(dp[i]>=0) return dp[i];
        
        int res=Integer.MAX_VALUE;
        int j=1;int m=1;
        for(j=1;j<i;j=(1<<(++m))-1){
            for(int q=0,p=0;p<j;p=(1 << ++q)-1){
                res=Math.min(res,m+1+q+1+solver(i-(j-p),dp));
            }
        }
        
        res=Math.min(res,m+(i==j?0:(1+solver(j-i,dp))));
        
        return dp[i]=res;
    }
}