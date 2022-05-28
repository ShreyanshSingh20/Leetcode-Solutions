class Solution {
    public long maximumImportance(int n, int[][] roads) {
		int e = roads.length;
		int deg[] = new int[n];
		for (int i = 0; i < e; i++) {
			deg[roads[i][0]]++;
			deg[roads[i][1]]++;
		}

		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Pair(i, deg[i]));
		}

		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.deg - o1.deg;
			}

		});

		HashMap<Integer, Integer> map = new HashMap<>();
		int val = n;
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).node, val);
			val--;
		}

		long score = 0;
		for (int i = 0; i < e; i++) {
			int u = roads[i][0];
			int v = roads[i][1];
			score += (long) map.get(u) + (long) map.get(v);
		}

		return (score);
    }
}

class Pair {
		int node;
		int deg;

		public Pair(int node, int deg) {
			super();
			this.node = node;
			this.deg = deg;
		}

	}