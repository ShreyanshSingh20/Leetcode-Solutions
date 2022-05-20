class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        
        int dp[][]=new int[r][c];
        
        boolean obstacleEncountered=false;
        
        for(int i=0;i<r;i++){
            if(mat[i][0]==1){
                obstacleEncountered=true;
            }
            
            if(obstacleEncountered) dp[i][0]=0;
            else dp[i][0]=1;
        }
        
        obstacleEncountered=false;
        
        for(int i=0;i<c;i++){
            if(mat[0][i]==1){
                obstacleEncountered=true;
            }
            
            if(obstacleEncountered) dp[0][i]=0;
            else dp[0][i]=1;
        }
        
        
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(mat[i][j]==1) dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        
        return dp[r-1][c-1];
    }
}