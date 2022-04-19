class Solution {
     public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
    }
    
    private boolean isMatch(char a[], char b[], int i, int j, Boolean[][] dp){
        if(i >= a.length && j >= b.length){
            return true;
        }
       
        if(j >= b.length){
            return false;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
       
        boolean matchCondition = i < a.length && (a[i] == b[j] || b[j] == '.');
        
        if(j + 1 <b.length && b[j+1] == '*'){
            dp[i][j] = isMatch(a, b, i, j + 2, dp) ||                        
                       matchCondition && isMatch(a, b, i + 1, j, dp); 
        } else {
            if(matchCondition){
                dp[i][j] = isMatch(a, b, i + 1, j + 1, dp);                  
            } else {
                dp[i][j] = false;
            }
        }
        
        return dp[i][j];
    }
}