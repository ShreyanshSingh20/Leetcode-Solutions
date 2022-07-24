class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int i=0;int j=mat[0].length-1;
        
        while(i>=0&&i<mat.length&&j>=0&&j<mat[0].length){
            if(mat[i][j]>target){
                j--;
            }else if(mat[i][j]<target){
                i++;
            }else{
                return true;
            }
        }
        
        return false;
    }
}