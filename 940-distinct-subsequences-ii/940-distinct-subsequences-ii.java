class Solution {
    public long mod=1_000_000_007;
    public int distinctSubseqII(String s) {
        int n=s.length();
        long dp[]=new long[n+1];
        dp[0]=1;//empty string
        
        int lastOccurence[]=new int[26];
        Arrays.fill(lastOccurence,-1);
        
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            dp[i+1]=mul(2,dp[i]);
            if(lastOccurence[c-'a']>=0){
                dp[i+1]=sub(dp[i+1],dp[lastOccurence[c-'a']]);
            }
            lastOccurence[c-'a']=i;
        }
        
        return (int)sub(dp[n],1);
    }
    
    public long mul(long x,long y){
        return (x*y)%mod;
    }
    
    public long add(long x,long y){
        x+=y;
        if(x>=mod) return x%mod;
        return x;
    }
    
    public long sub(long x,long y){
        x-=y;
        if(x<0) return x+mod;
        return x;
    }
}