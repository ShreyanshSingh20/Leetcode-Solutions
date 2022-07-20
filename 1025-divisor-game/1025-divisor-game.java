class Solution {
    public boolean divisorGame(int n) {
        Boolean dp[]=new Boolean[n+1];
        return solver(n,dp);
    }
    
    //this function states if alice can win or not
    public boolean solver(int n,Boolean dp[]){
        
        //if we reach end with alice's turn then he loses
        if(n<=1){
            return false;
        }
        
        if(dp[n]!=null) return dp[n];
        
        for(int x=1;x<n;x++){
            if(n%x==0){
                //finding out if bob loses or wins
                boolean ans=solver(n-x,dp);
                //if bob loses then alice wins
                if(ans==false) return dp[n]=true;
            }
        }
        
        //otherwise alice definitely loses
        return dp[n]=false;
    }
}