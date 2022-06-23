class Solution {
    public int minimumNumbers(int num, int k) {
        List<Integer> set=new ArrayList<>();
		for(int i=1;i<=num;i++) {
			String s=i+"";
			if(s.charAt(s.length()-1)-'0'==k) set.add(i);
		}
        
        int dp[]=new int[num+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
		for(int i=1;i<=num;i++){
            for(int c:set){
                if(i>=c&&dp[i-c]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[i-c]);
                }
            }
        }
        
        return (dp[num]==Integer.MAX_VALUE?-1:dp[num]);
    }
    
   
}