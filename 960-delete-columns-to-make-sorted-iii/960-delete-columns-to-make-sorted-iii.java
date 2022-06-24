class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
		int col = strs[0].length();
		int dp[] = new int[col];
		Arrays.fill(dp,1);int res=col-1;
		for (int i = 1; i < col; i++) {
			for(int j=0;j<i;j++){
                int k=0;
                for(k=0;k<row;k++){
                    if(strs[k].charAt(j)>strs[k].charAt(i)) break; 
                }
                if(k==row){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.min(res,col-dp[i]);
		}

		

		return res;
    }
}