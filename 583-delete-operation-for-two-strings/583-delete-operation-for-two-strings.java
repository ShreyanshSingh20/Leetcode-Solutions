class Solution {
    public int minDistance(String word1, String word2) {
        char a[]=word1.toCharArray();
        char b[]=word2.toCharArray();
        int dp[][]=new int[a.length+1][b.length+1];
        for(int x[]:dp) Arrays.fill(x,-1);
        
        return a.length+b.length-2*(solver(a,b,0,0,dp));
    }
    
    public int solver(char a[],char b[],int i,int j,int dp[][]){
        
        if(i==a.length||j==b.length) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(a[i]==b[j]){
            return dp[i][j]=1+solver(a,b,i+1,j+1,dp);
        }else{
            return dp[i][j]=Math.max(solver(a,b,i+1,j,dp),solver(a,b,i,j+1,dp));
        }
    }
}