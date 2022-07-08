class Solution {
		public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

			long dp[][][] = new long[101][21][101];
			for (long x[][] : dp) {
				for (long y[] : x) {
					Arrays.fill(y, -1);
				}
			}

			int ans = (int) rec(0, houses, houses[0], 0, cost, target, n, dp);
			if (ans == Integer.MAX_VALUE)
				return -1;
			return ans;
		}

		public long rec(int i, int houses[], int prevHouseColour, int numOfHoods, int cost[][], int target, int n,
				long dp[][][]) {

			if (i == houses.length) {
				if (numOfHoods + 1 == target)
					return 0;
				return Integer.MAX_VALUE;
			}

			if (dp[i][prevHouseColour][numOfHoods] != -1)
				return dp[i][prevHouseColour][numOfHoods];

			long res = Integer.MAX_VALUE;
			if (houses[i] == 0) {
				for (int j = 0; j < n; j++) {
					int newHoods = numOfHoods;
					if (i != 0 && j + 1 != prevHouseColour)
						newHoods = numOfHoods + 1;
					res = Math.min(res, cost[i][j] + rec(i + 1, houses, j + 1, newHoods, cost, target, n, dp));
				}
			} else {
				int newHoods = numOfHoods;
				if (houses[i] != prevHouseColour)
					newHoods = numOfHoods + 1;
				res = Math.min(res, rec(i + 1, houses, houses[i], newHoods, cost, target, n, dp));
			}

			return dp[i][prevHouseColour][numOfHoods] = res;
		}
	}