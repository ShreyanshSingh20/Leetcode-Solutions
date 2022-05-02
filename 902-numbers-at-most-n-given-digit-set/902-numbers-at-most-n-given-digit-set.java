class Solution {
    public int atMostNGivenDigitSet(String[] digits, int num) {
        String str = String.valueOf(num);
		int len = str.length();

        int n = digits.length;
        
		int dp[] = new int[len + 1];
		dp[len] = 1;

		for (int i = len - 1; i >= 0; i--) {
			int currVal = str.charAt(i) - '0';
			for (String s : digits) {
				int val = Integer.valueOf(s);
				if (val < currVal) {
					dp[i] += Math.pow(n, len - i - 1);
				} else if (val == currVal) {
					dp[i] += dp[i + 1];
				}
			}
		}

		for (int i = 1; i < len; i++) {
			dp[0] += Math.pow(n, i);
		}

		return (dp[0]);
    }
}