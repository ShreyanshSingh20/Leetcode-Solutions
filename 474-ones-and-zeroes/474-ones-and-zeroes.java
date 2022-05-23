class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        List<int[]> list=new ArrayList<>();
		for (int i = 0; i < strs.length;i++) {
			String currString=strs[i];
			int cnt0=0;int cnt1=0;
			for(int j=0;j<currString.length();j++) {
				if(currString.charAt(j)=='0') cnt0++;
				else cnt1++;
			}
			list.add(new int[] {cnt0,cnt1});
		}
		int size=list.size();
        int dp[][][]=new int[size+1][m+1][n+1];
        for(int x[][]:dp){
            for(int y[]:x) Arrays.fill(y,-1);
        }
		int res=solver(list, 0, m, n, dp);
        return res;
    }
    
    public int solver(List<int[]> list, int i,int m,int n,int dp[][][]) {
		
		if(i==list.size()) {
			return 0;
		}
        
        if(dp[i][m][n]!=-1) return dp[i][m][n];
		
		int res=0;
		if(list.get(i)[0]<=m&&list.get(i)[1]<=n) {
			res=Math.max(solver(list, i+1, m, n, dp),1+
					solver(list, i+1, m-list.get(i)[0], n-list.get(i)[1], dp));
		}else {
			res=Math.max(res, solver(list, i+1, m, n, dp));
		}
		
		return dp[i][m][n]=res;
	}
}