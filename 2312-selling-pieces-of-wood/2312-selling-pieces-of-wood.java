class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        
       HashMap<Integer, HashMap<Integer, Long>> map = new HashMap<>();

		for (int i = 0; i < prices.length; i++) {
			int row = prices[i][0];
			int col = prices[i][1];
			int price = prices[i][2];
			map.putIfAbsent(row, new HashMap<>());
			map.get(row).put(col, (long) price);
		}
        
		long dp[][] = new long[m + 1][n + 1];
        
		for (long x[] : dp)
			Arrays.fill(x, -1);
        
		return solver(m, n, map, dp);
        
    }
    
    public long solver(int row, int col, HashMap<Integer, HashMap<Integer, Long>> map, long dp[][]) {

		long ans = 0;
		if (map.containsKey(row)) {
			if (map.get(row).containsKey(col)) {
				ans = map.get(row).get(col);
			}
		}

		if (dp[row][col] != -1)
			return dp[row][col];

		// horizontal partioning
		for (int i = 1; i <= row / 2; i++) {
			ans = Math.max(ans, solver(i, col, map, dp) + solver(row - i, col, map, dp));
		}

		// vertical partitioning
		for (int i = 1; i <= col / 2; i++) {
			ans = Math.max(ans, solver(row, i, map, dp) + solver(row, col - i, map, dp));
		}

		return dp[row][col] = ans;
	}
}