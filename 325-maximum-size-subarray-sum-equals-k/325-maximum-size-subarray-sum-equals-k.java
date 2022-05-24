class Solution {
    public int maxSubArrayLen(int[] arr, int k) {
        int n = arr.length;

		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		long psum = 0;
		int len = 0;
		for (int i = 0; i < n; i++) {
			psum += arr[i];
			if (map.containsKey(psum - k)) {
				len = Math.max(len, i - map.get(psum - k));
			}
			map.putIfAbsent(psum, i);
			if (psum == k) {
				len = Math.max(len, i + 1);
			}
		}

		return len;
    }
}