class Solution {
    public long mod=1_000_000_007;
    public int countHousePlacements(int n) {
        long dp[]=new long[n+1];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<=n;i++){
            dp[i]=add(dp[i-2],dp[i-1]);
        }
        
        return (int)mul(dp[n],dp[n]);
    }
    
    public long add(long x,long y){
        x+=y;
        if(x>=mod) return x%mod;
        return x;
    }
    
    public long mul(long x,long y){
        return (x*y)%mod;
    }
}