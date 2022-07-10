class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,cost,dp);
    }
    
    //starting from 0
    public int solve(int i,int cost[],int dp[]){
        if(i==cost.length) return 0;
        if(i>cost.length) return Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        int ans=Integer.MAX_VALUE;
        if(i==0){
            ans=Math.min(cost[i]+solve(i+1,cost,dp),Math.min(cost[i]+solve(i+2,cost,dp),solve(i+1,cost,dp)));
        }else{
            ans=Math.min(ans,cost[i]+Math.min(solve(i+1,cost,dp),solve(i+2,cost,dp)));
        }
        return dp[i]=ans;
    }
    
    
}