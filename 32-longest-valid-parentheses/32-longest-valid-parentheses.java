class Solution {
    public int longestValidParentheses(String s) {
        char c[]=s.toCharArray();
        int n=c.length;
        if(n==0) return 0;
        int dp[]=new int[n+1];
        dp[0]=0;dp[1]=0;
        for(int i=1;i<n;i++){
            if(c[i]==')'){
                if(c[i-1]=='('){
                    if(i==1) dp[i+1]=2;
                    else dp[i+1]=dp[i-1]+2;
                }else if(c[i-1]==')'){
                    if(i-dp[i]-1>=0&&c[i-dp[i]-1]=='(') dp[i+1]=dp[i-dp[i]-1]+dp[i]+2;
                }else{
                    dp[i+1]=0;
                }
            }else{
                dp[i+1]=0;
            }
        }
        
        int max=Integer.MIN_VALUE;
        for(int x:dp) max=Math.max(max,x);
        
        return max;
    }
    
}