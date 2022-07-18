class Solution {
    public boolean exist(char[][] mat, String word) {
        char c[]=word.toCharArray();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==c[0]){
                    if(dfs(mat,i,j,c,0,new boolean[mat.length][mat[0].length])) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char mat[][],int i,int j,char c[],int k,boolean vis[][]){
        if(k==c.length) return true;
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||vis[i][j]) return false;
        if(mat[i][j]!=c[k]) return false;
        vis[i][j]=true;
        for(int l=0;l<4;l++){
            int newx=i+offset[l][0];
            int newy=j+offset[l][1];
            if(dfs(mat,newx,newy,c,k+1,vis)) return true;
        }
        vis[i][j]=false;
        return false;
    }
    
    public int offset[][]={
        {1,0},{0,1},{-1,0},{0,-1}
    };
}