class Solution {
    public int missingElement(int[] nums, int k) {
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] - nums[i] - 1 >= k)
                return nums[i] + k;
            k = k - (nums[i + 1] - nums[i] - 1);
        }
        return nums[nums.length - 1] + k;
    }
}