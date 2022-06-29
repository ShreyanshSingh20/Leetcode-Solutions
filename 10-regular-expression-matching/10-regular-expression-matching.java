class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][]=new Boolean[s.length()+2][p.length()+2];
        return solver(s,p,0,0,dp);
    }
    
    public boolean solver(String s,String p,int i,int j,Boolean dp[][]){
        
        if(i>=s.length()&&j>=p.length()) return true;
        
        if(j>=p.length()) return false;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        boolean matching=i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
        
        if(j+1<p.length()&&p.charAt(j+1)=='*'){
            dp[i][j]=solver(s,p,i,j+2,dp)||
                        matching&&solver(s,p,i+1,j,dp);
        }else{
            if(matching){
                dp[i][j]=solver(s,p,i+1,j+1,dp);
            }else{
                dp[i][j]=false;
            }
        }
        
        return dp[i][j];
    }
}