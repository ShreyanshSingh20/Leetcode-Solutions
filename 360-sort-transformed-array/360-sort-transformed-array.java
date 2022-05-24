class Solution {
    public int[] sortTransformedArray(int[] arr, int a, int b, int c) {
        int n = arr.length;
		int res[] = new int[n];
		int l = 0;
		int r = n - 1;
		int index = (a >= 0) ? n - 1 : 0;
		while (l <= r) {
			if (a >= 0) {
				res[index--] = (fx(arr[l], a, b, c) >= fx(arr[r], a, b, c)) ? fx(arr[l++], a, b, c)
						: fx(arr[r--], a, b, c);
			} else {
				res[index++] = (fx(arr[l], a, b, c) <= fx(arr[r], a, b, c)) ? fx(arr[l++], a, b, c)
						: fx(arr[r--], a, b, c);
			}
		}
        
        return res;
    }

    public int fx(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
}