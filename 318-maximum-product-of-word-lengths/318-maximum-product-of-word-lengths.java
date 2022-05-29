class Solution {
    public int maxProduct(String[] arr) {
        int n = arr.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c[] = arr[i].toCharArray();
			int bitmask = 0;
			for (int j = 0; j < c.length; j++) {
				int ind = c[j] - 'a';
				bitmask = bitmask | (1 << ind);
			}
			if (map.containsKey(bitmask) && map.get(bitmask) < c.length) {
				map.put(bitmask, c.length);
			} else if (!map.containsKey(bitmask)) {
				map.put(bitmask, c.length);
			}
		}

		List<int[]> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();
			list.add(new int[] { key, val });
		}

		int res = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
                int bitmaskA=list.get(i)[0];
                int bitmaskB=list.get(j)[0];
                if((bitmaskA&bitmaskB)!=0) continue;
				int a = list.get(i)[1];
				int b = list.get(j)[1];
				res = Math.max(res, a * b);
			}
		}
		return (res);
    }
}