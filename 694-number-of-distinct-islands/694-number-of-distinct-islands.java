class Solution {
    public int numDistinctIslands(int[][] mat) {
        int r=mat.length;
		int c=mat[0].length;
		
		HashSet<String> hashSet=new HashSet<>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(mat[i][j]==1) {
					StringBuilder str=new StringBuilder();
					dfs(i, j, mat, str, 'S');
					hashSet.add(str.toString());
				}
			}
		}
		return hashSet.size();
    }
    
    public void dfs(int i,int j,int mat[][],StringBuilder s,char dir) {
		if(i<0||j<0||i>=mat.length||j>=mat[0].length||mat[i][j]==0) return;
		mat[i][j]=0;
		if(dir!='S') s.append(dir);
		dfs(i+1, j, mat, s, 'D');
		dfs(i-1, j, mat, s, 'U');
		dfs(i, j+1, mat, s, 'R');
		dfs(i, j-1, mat, s, 'L');
		s.append(0);
	}
}