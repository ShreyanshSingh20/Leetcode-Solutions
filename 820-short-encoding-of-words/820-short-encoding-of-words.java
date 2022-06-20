class Solution {
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Pair(words[i], words[i].length()));
		}

		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.len - o2.len;
			}
		});

		int ans = bfs(list);
		return ans;
    }
    
    public int bfs(List<Pair> list) {
		int n = list.size();
		boolean vis[] = new boolean[n];
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				res.append(bfsSolver(list, vis, i));
			}
		}
		System.out.println(res.toString());
		return res.length();
	}

	public String bfsSolver(List<Pair> list, boolean vis[], int source) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(source);
		vis[source] = true;
		int lastInd = -1;
		while (!queue.isEmpty()) {
			int currInd = queue.poll();
			lastInd = currInd;
			String currString = list.get(currInd).str;
			for (int j = 0; j < list.size(); j++) {
				if (!vis[j]) {
					String str = list.get(j).str;
					if (str.endsWith(currString)) {
						queue.add(j);
						vis[j] = true;
						break;
					}
				}
			}
		}

		return list.get(lastInd).str + "#";
	}

}

class Pair {
		String str;
		int len;

		public Pair(String str, int len) {
			super();
			this.str = str;
			this.len = len;
		}

	}