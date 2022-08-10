class Solution {
    public int jump(int[] nums) {
        int cnt = 0, farCanReach = 0, end = 0;
        for(int i = 0; end < nums.length - 1; end = farCanReach) {
            cnt++;
            while(i < nums.length && i <= end) {
                farCanReach = Math.max(farCanReach, i + nums[i++]);
            }           
            if(end == farCanReach) return -1;
        }
        return cnt;
    }
}