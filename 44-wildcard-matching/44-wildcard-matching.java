class Solution {
    public boolean isMatch(String s, String p) {
        char a[]=s.toCharArray();int n=a.length;
        char b[]=p.toCharArray();int m=b.length;
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++) dp[i][0]=false;
        for(int j=1;j<=m;j++){
            boolean flag=true;
            for(int pt=1;pt<=j;pt++){
                if(b[pt-1]!='*') {flag=false; break;}
            }
            dp[0][j]=flag;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1]||b[j-1]=='?') dp[i][j]=dp[i-1][j-1];
                else if(b[j-1]=='*') dp[i][j]=dp[i-1][j]|dp[i][j-1];
                else dp[i][j]=false;
            }
        }
        
        return dp[n][m];
        // return solver(a,b,n,m,dp)==1?true:false;
    }
    
//     public int solver(char a[],char b[],int i,int j,int dp[][]){
        
//         if(i<=0&&j<=0) return 1;
//         if(i>0&&j<=0) return 0;
//         if(i<=0&&j>0){
//             int flag=1;
//             for(int pt=1;pt<=j;pt++){
//                 if(b[pt-1]!='*') {flag=0; break;}
//             }
//             return flag;
//         }
        
//         if(dp[i][j]!=-1) return dp[i][j];
        
//         if(a[i-1]==b[j-1]||b[j-1]=='?') return dp[i][j]=solver(a,b,i-1,j-1,dp);
//         if(b[j-1]=='*') return dp[i][j]=solver(a,b,i-1,j,dp)|solver(a,b,i,j-1,dp);
        
//         return 0;
//     }
}