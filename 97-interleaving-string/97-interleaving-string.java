class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        char a[]=s1.toCharArray();
        char b[]=s2.toCharArray();
        char c[]=s3.toCharArray();
        
        Boolean dp[][][]=new Boolean[a.length+1][b.length+1][c.length+1];
        return solver(a,b,c,0,0,0,dp);
        
    }
    
    public boolean solver(char a[],char b[],char c[],int i,int j,int k,Boolean dp[][][]){
        
        if(i==a.length&&j==b.length&&k==c.length) return true;
        if(k>=c.length&&(i<a.length||j<b.length)) return false;
        if(k<c.length&&(i==a.length&&j==b.length)) return false;
        
        if(dp[i][j][k]!=null) return dp[i][j][k];
        
        if(i<a.length&&j<b.length&&k<c.length&&a[i]==c[k]&&b[j]==c[k]){
            return dp[i][j][k]=(solver(a,b,c,i+1,j,k+1,dp)||solver(a,b,c,i,j+1,k+1,dp));
        }else if(i<a.length&&k<c.length&&a[i]==c[k]){
            return dp[i][j][k]=solver(a,b,c,i+1,j,k+1,dp);
        }else if(j<b.length&&k<c.length&&b[j]==c[k]){
            return dp[i][j][k]=solver(a,b,c,i,j+1,k+1,dp);
        }
        
        return dp[i][j][k]=false;
    }
}