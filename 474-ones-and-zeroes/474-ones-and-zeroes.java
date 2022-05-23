class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][]=new int[n+1][m+1];
        for(String str:strs){
            int cnt[]=count(str);
            for(int i=n;i>=cnt[1];i--){
                for(int j=m;j>=cnt[0];j--){
                    dp[i][j]=Math.max(dp[i][j],1+dp[i-cnt[1]][j-cnt[0]]);
                }
            }
        }
        
        return dp[n][m];
    }
    
    public int[] count(String str){
        int cnt0=0;
        int cnt1=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0') cnt0++;
            else cnt1++;
        }
        
        return new int[]{cnt0,cnt1};
    }
}