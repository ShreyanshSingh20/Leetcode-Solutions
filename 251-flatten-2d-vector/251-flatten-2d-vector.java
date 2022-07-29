class Vector2D {

    int mat[][];
    int currRow;int currCol;
    public Vector2D(int[][] vec) {
        this.mat=vec;
        this.currRow=0;this.currCol=0;
        while(currRow<mat.length&&mat[currRow].length==0) currRow++;
    }
    
    public int next() {
        while(currRow<mat.length&&mat[currRow].length==0) currRow++;
        int res=this.mat[currRow][currCol];
        if(currCol+1<mat[currRow].length) currCol++;
        else if(currRow+1<mat.length) {
            currRow++;
            currCol=0;
        }else{
            currRow++;
            currCol++;
        }
        return res;
    }
    
    public boolean hasNext() {
        while(currRow<mat.length&&mat[currRow].length==0) currRow++;
        if(currRow<mat.length&&currCol<mat[currRow].length) return true;
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */