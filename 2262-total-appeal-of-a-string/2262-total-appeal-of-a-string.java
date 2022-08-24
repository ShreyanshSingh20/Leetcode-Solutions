class Solution {
    public long appealSum(String s) {
        
        char c[]=s.toCharArray();
        int n=c.length;
        
        int last[]=new int[26];
        Arrays.fill(last,-1);
        
        long dp[]=new long[n];
        dp[0]=1;
        
        last[c[0]-'a']=0;
        
        long sum=dp[0];
        
        for(int i=1;i<n;i++){
            
            long prev=dp[i-1];
            long Q=0;
            
            int ch=c[i]-'a';
            
            if(last[ch]==-1){
                Q=i;
                last[ch]=i;
            }else{
                Q=i-last[ch]-1;
                last[ch]=i;
            }
            
            dp[i]+=(prev+Q+1);
            
            sum+=dp[i];
        }
        
        return sum;
    }
}