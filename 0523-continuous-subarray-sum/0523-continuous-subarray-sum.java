class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();
        long prefSum[] = new long[n];
        prefSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
        }

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long mod = sum % (long) k;
            if (mod == 0 && i + 1 >= 2) return true;
            if (map.containsKey(mod)) {
                int prevInd = map.get(mod);
                if (i - prevInd >= 2 && (sum - prefSum[prevInd]) % k == 0) return true;
            }
            map.putIfAbsent(mod, i);
        }

        return false;
    }
}
