class NumMatrix {

		int r;
		int c;
		int psum[][];

		public NumMatrix(int[][] mat) {
			this.r = mat.length;
			this.c = mat[0].length;
			psum = new int[r][c];
			psum[0][0] = mat[0][0];
			for (int i = 1; i < c; i++)
				psum[0][i] = psum[0][i - 1] + mat[0][i];
			for (int i = 1; i < r; i++)
				psum[i][0] = psum[i - 1][0] + mat[i][0];

			for (int i = 1; i < r; i++) {
				for (int j = 1; j < c; j++) {
					psum[i][j] = mat[i][j] + psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (row1 == 0 && col1 != 0) {
				return psum[row2][col2] - psum[row2][col1 - 1];
			} else if (row1 != 0 && col1 == 0) {
				return psum[row2][col2] - psum[row1 - 1][col2];
			} else if (row1 == 0 && col1 == 0) {
				return psum[row2][col2];
			}

			return psum[row2][col2] - (psum[row1 - 1][col2] + psum[row2][col1 - 1]) + psum[row1 - 1][col1 - 1];
		}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */