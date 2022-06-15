class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
		HashMap<Integer, List<Info>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int len = words[i].length();
			map.putIfAbsent(len, new ArrayList<>());
			map.get(len).add(new Info(words[i], i));
		}

		boolean vis[] = new boolean[n];

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= 16; i++) {
			if (!map.containsKey(i))
				continue;
			Queue<Pair> q = new ArrayDeque<>();

			for (Info x : map.get(i)) {
				if (vis[x.ind])
					continue;
				q.add(new Pair(x.str, 1));
			}

			while (!q.isEmpty()) {
				int size = q.size();
				for (int j = 0; j < size; j++) {
					Pair curr = q.poll();
					String str = curr.str;
					int chainLength = curr.len;
					int strLen = str.length();
					max = Math.max(max, chainLength);
					if (!map.containsKey(strLen + 1))
						continue;
					for (Info x : map.get(strLen + 1)) {
                        if(vis[x.ind]) continue;
						if (isSubsequence(str, x.str)) {
							q.add(new Pair(x.str, chainLength + 1));
							vis[x.ind] = true;
						}
					}
				}
			}
		}

        
        return max;
    }
    
   public boolean isSubsequence(String a, String b) {
		int l = 0;
		int r = 0;
		while (l < a.length() && r < b.length()) {
			if (a.charAt(l) == b.charAt(r)) {
				l++;
				r++;
			} else {
				r++;
			}
		}
		return l == a.length();
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

class Info{
		String str;
		int ind;
		public Info(String str, int ind) {
			super();
			this.str = str;
			this.ind = ind;
		}
		
		
	}