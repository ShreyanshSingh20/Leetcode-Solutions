class Solution {
    int res;
    public int totalNQueens(int n) {
        this.res=0;
	    char mat[][]=new char[n][n];
	    int row[]=new int[n];
	    int col[]=new int[n];
	    int btot[]=new int[2*n-1];
	    int ttob[]=new int[2*n-1];
	    for(char x[]:mat) Arrays.fill(x,'.');
	    solver(0, n, mat, row, col, btot, ttob);
	    return res;
    }
    
     public void solver(int i,int n,char mat[][],int row[],int col[],int btot[],int ttob[]) {
	    	
	    	if(i==n) {
	    		res++;
	    		return;
	    	}
	    	
	    	for(int j=0;j<n;j++) {
	    		if(isSafe(i,j,mat,row,col,btot,ttob)) {
	    			set(i,j,mat,row,col,btot,ttob,'Q');
	    			solver(i+1, n, mat, row, col, btot, ttob);
	    			set(i,j,mat,row,col,btot,ttob,'.');
	    		}
	    	}
	    	
	    }
	    
	    public void set(int i,int j,char mat[][],int row[],int col[],int btot[],int ttob[],char val) {
	    	mat[i][j]=val;
	    	row[i]=val=='Q'?1:0;
	    	col[j]=val=='Q'?1:0;
	    	btot[i+j]=val=='Q'?1:0;
	    	ttob[i-j+mat.length-1]=val=='Q'?1:0;
	    }
	    
	    public boolean isSafe(int i,int j,char mat[][],int row[],int col[],int btot[],int ttob[]) {
	    	if(row[i]==1||col[j]==1||btot[i+j]==1||ttob[i-j+mat.length-1]==1) return false;
	    	return true;
	    }
}