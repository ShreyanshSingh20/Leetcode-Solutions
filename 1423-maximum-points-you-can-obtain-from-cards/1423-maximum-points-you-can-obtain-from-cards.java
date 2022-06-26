class Solution {
    public int maxScore(int[] arr, int k) {
        
        int n = arr.length;

		int prefSum[] = new int[n];
		int suffSum[] = new int[n];

		prefSum[0] = arr[0];
		for (int i = 1; i < n; i++)
			prefSum[i] = prefSum[i - 1] + arr[i];

		suffSum[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			suffSum[i] = suffSum[i + 1] + arr[i];

		int res = 0;

		for (int num = 0; num <= k; num++) {
			
			// taking num number of cards from prefix
			// taking k-num number of cards from suffix

			int indexPrefix = (num == 0) ? -1 : num - 1;
			int indexSuffix = (k - num == 0) ? -1 : n - (k - num);

			int prefValue = (indexPrefix == -1) ? 0 : prefSum[indexPrefix];
			int suffValue = (indexSuffix == -1) ? 0 : suffSum[indexSuffix];

			res = Math.max(res, prefValue + suffValue);
		}
        
        return res;
    }
}
//   0   1   2   3  4  5  6
//   1   2   3   4  5  6  1
// p 1   3   6  10 15 21 22
// s 22  21  19 16 12 7  1
      
// 12  (1+7)  (3+1) 6
// 12    8     4    6