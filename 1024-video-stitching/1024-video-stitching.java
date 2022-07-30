class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        //let dp[t]->represent the minimum number of clips taken to cover till time 't'
        int dp[]=new int[105];
        Arrays.fill(dp,Integer.MAX_VALUE/4);
        dp[0]=0;
        
        for(int t=0;t<=time;t++){
            for(int clip[]:clips){
                int start=clip[0];int end=clip[1];
                //if the starting time is smaller than current time 't' and the 
                //ending time is bigger than the current time 't' then we can effectively take this
                //clip to contribute to our answer
                if(start<=time&&end>=t){
                    dp[t]=Math.min(dp[t],dp[start]+1);
                }
            }
        }
        
        return dp[time]==Integer.MAX_VALUE/4?-1:dp[time];
    }
}