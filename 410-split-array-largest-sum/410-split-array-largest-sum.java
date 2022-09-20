class Solution {
    public int splitArray(int[] arr, int d) {
        int n=arr.length;
		d=Math.min(d,n);
		int dp[][]=new int[n+1][d+1];
		for(int x[]:dp) Arrays.fill(x, -1);
		return solver(arr, 0, d-1, dp);
    }
    
    public int solver(int arr[],int i,int d,int dp[][]) {
		
		if(d==0) {
			int sum=0;
			for(int j=i;j<arr.length;j++) sum+=arr[j];
			return sum;
		}
		
		if(dp[i][d]!=-1) return dp[i][d];
		
		int sum=0;int res=Integer.MAX_VALUE;
		for(int j=i;j<arr.length-d;j++) {
			sum+=arr[j];
			res=Math.min(res, Math.max(sum,solver(arr, j+1, d-1, dp)));
		}
		
		return dp[i][d]=res;
	}
}