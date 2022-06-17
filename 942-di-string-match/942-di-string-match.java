class Solution {
    public int[] diStringMatch(String s) {
        char c[] = s.toCharArray();
		int n = c.length;
		List<Integer> list = new ArrayList<>();
		int prev = 0;
		if (c[0] == 'I') {
			list.add(0);
			list.add(1);
			prev = 1;
		} else {
			list.add(0);
			list.add(-1);
			prev = -1;
		}

		for (int i = 1; i < c.length; i++) {
			if (c[i] == c[i - 1]) {
				if (c[i] == 'I') {
					prev += 1;
					list.add(prev);
				} else {
					prev -= 1;
					list.add(prev);
				}
			} else {
				if (c[i] == 'I') {
					prev += (i + 1);
					list.add(prev);
				} else {
					prev -= (i + 1);
					list.add(prev);
				}
			}
		}

		int totalSum = (n) * (n + 1) / 2;
		int sum = 0;
		for (int x : list)
			sum += x;
		totalSum -= sum;
		int x = totalSum / (n + 1);

		int res[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			res[i] = x + list.get(i);
		}
        
        return res;
    }
}