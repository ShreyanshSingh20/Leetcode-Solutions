class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        
        List<Integer> res=new ArrayList<>();
        
        int k=0;//starting row index;
        int r=mat.length;//ending row index
        int l=0;//starting column index
        int c=mat[0].length;//ending column index
        
        while(k<r&&l<c){
            //filling the first row
            for(int i=l;i<c;i++){
                res.add(mat[k][i]);
            }
            k++;
            
            //filling the last column
            for(int i=k;i<r;i++){
                res.add(mat[i][c-1]);
            }
            c--;
            
            //filling the last row
            if(k<r){
                for(int i=c-1;i>=l;i--){
                    res.add(mat[r-1][i]);
                }
                r--;
            }
            
            //filling the first column
            if(l<c){
                for(int i=r-1;i>=k;i--){
                    res.add(mat[i][l]);
                }
                l++;
            }
        }
        return res;
    }
}