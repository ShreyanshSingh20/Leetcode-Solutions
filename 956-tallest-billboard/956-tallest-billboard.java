class Solution {
    public int tallestBillboard(int[] arr) {
        //dp[diff]=maximum height possible with this difference in sums
        int dp[]=new int[5001];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0]=0;
		for(int x:arr) {
			int curr[]=dp.clone();
			for(int d=0;d+x<5001;d++) {
				dp[d+x]=Math.max(dp[d+x],curr[d]);//adding on the larger side
                //adding on the smaller side
				dp[Math.abs(d-x)]=Math.max(dp[Math.abs(d-x)], curr[d]+Math.min(d,x));
			}
		}
        
        return dp[0];
    }
}