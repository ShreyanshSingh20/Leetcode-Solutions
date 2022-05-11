class Solution {
    public int countVowelStrings(int n) {
		int dp[][]=new int[n+1][6];
		for(int x[]:dp) Arrays.fill(x, -1);
		return solver(0, n, 1, dp);
    }
    
    public int solver(int i,int n,int currPos,int dp[][]) {
		
		if(i==n) {
			return 1;
		}
		
		if(dp[i][currPos]!=-1) return dp[i][currPos];
		
		int res=0;
		for(int j=currPos;j<=5;j++) {
			res+=solver(i+1, n, j, dp);
		}
		
		return dp[i][currPos]=res;
	}
}