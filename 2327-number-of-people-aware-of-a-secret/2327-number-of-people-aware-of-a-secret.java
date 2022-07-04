class Solution {
    public long mod=1_000_000_007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[]=new long[n+1];
        dp[1]=1;
        long share=0;
        
        for(int i=2;i<=n;i++){
            if(i-delay>=0){
                share=add(share,dp[i-delay]);
            }
            if(i-forget>=0){
                share=sub(share,dp[i-forget]);
            }
            dp[i]=share;
        }
        
        int pt=n;long res=0;
        while(forget>0){
            res=add(res,dp[pt]);
            pt--;
            forget--;
        }
        
        return (int)res;
        
    }
    
    public long add(long x,long y){
        x+=y;
        if(x>=y) return x%mod;
        return x;
    }
    
    public long sub(long x,long y){
        x-=y;
        if(x<0) return (x+mod);
        return x;
    }
}