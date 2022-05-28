class Solution {
    public long mod = 1_000_000_007;
    public int knightDialer(int n) {
        long res=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				if((i==3&&j==0)||(i==3&&j==2)) continue;
				long dp[][][]=new long[5][4][5001];
				for(long x[][]:dp) {
					for(long y[]:x) {
						Arrays.fill(y, -1);
					}
				}

				res=add(res, solver(i, j, n, 4, 3, dp));
			}
		}
        
        return (int)(res);
    }
    
    public int offsets[][]= {
			{-2,-1},{-2,1},
			{-1,-2},{-1,2},
			{1,-2},{1,2},
			{2,-1},{2,1}
	};
	
	public long solver(int i,int j,int n,int r,int c,long dp[][][]) {
		if(n==1) { return 1;}
		if(dp[i][j][n]!=-1) return dp[i][j][n];
		long res=0;
		for(int k=0;k<offsets.length;k++) {
			int newx=i+offsets[k][0];
			int newy=j+offsets[k][1];
			if(newx<0||newy<0||newx>=r||newy>=c||(newx==3&&newy==0)||(newx==3&&newy==2)) continue;
			res=add(res,solver(newx, newy, n-1, r, c, dp));
		}
		return dp[i][j][n]=res;
	}
    
    public long add(long x, long y) {
		x += y;
		if (x >= mod)
			return (x % mod);
		return x;
	}

}