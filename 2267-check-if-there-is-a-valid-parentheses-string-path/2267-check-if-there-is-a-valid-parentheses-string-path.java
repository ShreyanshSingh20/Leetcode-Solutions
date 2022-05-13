class Solution {
    public boolean hasValidPath(char[][] grid) {
        int r=grid.length;int c=grid[0].length;
        Boolean dp[][][]=new Boolean[r+1][c+1][205];
        return solver(grid,0,0,0,dp);
        
    }
    
    public boolean solver(char mat[][],int i,int j,int val,Boolean dp[][][]){
        if(i>=mat.length||j>=mat[0].length) return false;
        
        if(mat[i][j]=='(') val++;
        else val--;
        
        if(i==mat.length-1&&j==mat[0].length-1){
            return (val==0);
        }
        
        if(val<0) return false;
        
        if(dp[i][j][val]!=null) return dp[i][j][val];
        
        return (dp[i][j][val]=(solver(mat,i+1,j,val,dp)|solver(mat,i,j+1,val,dp)));
        
    }
}