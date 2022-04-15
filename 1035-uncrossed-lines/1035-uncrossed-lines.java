class Solution {
    public int maxUncrossedLines(int[] arr1, int[] arr2) {
        int n=arr1.length;int m=arr2.length;
       
        
        int dp[][]=new int[n+1][m+1];
		for(int x[]:dp) Arrays.fill(x, -1);
		
		return (helper(arr1, arr2, 0,0, dp));
    }
    
    public int helper(int a[],int b[],int i,int j,int dp[][]) {
		
		
		if(i==a.length||j==b.length) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		int res=0;
		if(a[i]==b[j]) {
			res=1+helper(a, b, i+1, j+1, dp);
		}else {
			res=Math.max(res,Math.max(helper(a,b, i+1, j, dp),
			helper(a,b, i, j+1, dp)));
		}
		
		return dp[i][j]=res;
		
	}
}