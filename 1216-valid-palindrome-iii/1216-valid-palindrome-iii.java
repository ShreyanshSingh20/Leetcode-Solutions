class Solution {
    public boolean isValidPalindrome(String s, int k) {
        char c[]=s.toCharArray();
        int dp[][]=new int[c.length+1][c.length+1];
        for(int x[]:dp) Arrays.fill(x,-1);
        if(solver(c,0,c.length-1,dp)<=k) return true;
        else return false;
    }
    
    public int solver(char c[],int l,int r,int dp[][]){
        if(l>=r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        if(c[l]==c[r]) return solver(c,l+1,r-1,dp);
        int res=0;
        res=1+Math.min(solver(c,l+1,r,dp),solver(c,l,r-1,dp));
        return dp[l][r]=res;
    }
}