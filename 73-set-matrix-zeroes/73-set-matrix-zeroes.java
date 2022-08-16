class Solution {
    public void setZeroes(int[][] mat) {
        
        int r=mat.length;
        int c=mat[0].length;
        
        boolean inCol=false;
        boolean inRow=false;
        
        for(int i=0;i<r;i++){
            if(mat[i][0]==0) inCol=true;
        }
        
        for(int i=0;i<c;i++){
            if(mat[0][i]==0) inRow=true;
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    mat[i][0]=0;
                    mat[0][j]=0;
                }
            }
        }
        
       
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(mat[i][0]==0||mat[0][j]==0) mat[i][j]=0;
            }
        }
        
        if(inRow) for(int i=0;i<c;i++) mat[0][i]=0;
        if(inCol) for(int i=0;i<r;i++) mat[i][0]=0;
        
        
    }
}