class Solution {
    public int videoStitching(int[][] clips, int T) {
        int end = 0, farCanReach = 0, cnt = 0;
        Arrays.sort(clips, (a, b) -> (a[0] - b[0])); // sort by start time
        for(int i = 0; end < T; end = farCanReach) {   // at the beginning of each step, we need update the "end"           
            cnt++;                       
            while(i < clips.length && clips[i][0] <= end) { // check all elements within the range
                farCanReach = Math.max(farCanReach, clips[i++][1]); // update the "farCanReach" for next step
            }
            if(end == farCanReach) return -1;   
			// if "farCanReach" isn't updated after we checked all elements within the range, we will fail in next step. 
			// say the first element in next step is [curS, curE], "curS" must be larger than "end" = "farCanReach".
        }		
        return cnt;
    }
}