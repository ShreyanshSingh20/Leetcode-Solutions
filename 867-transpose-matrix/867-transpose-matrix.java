class Solution {
    public int[][] transpose(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        
        int newRow=c;
        int newCol=r;
        int res[][]=new int[newRow][newCol];
        int ptx=0;int pty=0;
        for(int i=0;i<c;i++){
            pty=0;
            for(int j=0;j<r;j++){
                res[ptx][pty]=mat[j][i];
                pty++;
            }
            ptx++;
        }
        
        return res;
    }
}