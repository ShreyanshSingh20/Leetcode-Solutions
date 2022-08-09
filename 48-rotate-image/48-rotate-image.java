class Solution {
    public void rotate(int[][] mat) {
        
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        
        int l=0;int r=n-1;
        while(l<r){
            reverse(l,r,mat);
            l++;r--;
        }
    }
    
    public void reverse(int l,int r,int mat[][]){
        
        for(int i=0;i<mat.length;i++){
            int temp=mat[i][l];
            mat[i][l]=mat[i][r];
            mat[i][r]=temp;
        }
        
    }
}