class Solution {
    public boolean isMatch(String s, String p) {
        char a[]=s.toCharArray();int n=a.length;
        char b[]=p.toCharArray();int m=b.length;
        int dp[][]=new int[n+1][m+1];
        for(int x[]:dp) Arrays.fill(x,-1);
        return solver(a,b,n-1,m-1,dp)==1?true:false;
    }
    
    public int solver(char a[],char b[],int i,int j,int dp[][]){
        
        if(i<0&&j<0) return 1;
        if(i>=0&&j<0) return 0;
        if(i<0&&j>=0){
            int flag=1;
            for(int pt=0;pt<=j;pt++){
                if(b[pt]!='*') {flag=0; break;}
            }
            return flag;
        }
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(a[i]==b[j]||b[j]=='?') return dp[i][j]=solver(a,b,i-1,j-1,dp);
        if(b[j]=='*') return dp[i][j]=solver(a,b,i-1,j,dp)|solver(a,b,i,j-1,dp);
        
        return 0;
    }
}