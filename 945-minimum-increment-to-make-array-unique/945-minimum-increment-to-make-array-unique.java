class Solution {
    public int minIncrementForUnique(int[] arr) {
        int n = arr.length;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		int res = 0;
		for (int i = 0; i <= 200005; i++) {
            if(map.isEmpty()) break;
			Integer justSmallOrEqual = map.floorKey(i);
			if (justSmallOrEqual == null)
				continue;
			int freq = map.get(justSmallOrEqual);
			if (freq == 1)
				map.remove(justSmallOrEqual);
			else
				map.put(justSmallOrEqual, freq - 1);
			res += (i - justSmallOrEqual);
		}

        return res;
        
    }
}