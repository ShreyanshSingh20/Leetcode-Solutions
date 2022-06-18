class Solution {
    public int largestComponentSize(int[] arr) {
        int smallestPF[] = new int[100005];

		Arrays.fill(smallestPF, -1);
		for (int i = 2; i < 100005; i++) {
			if (smallestPF[i] == -1) {
				smallestPF[i] = i;
				for (int j = i * 2; j < 100005; j = j + i) {
					if (smallestPF[j] == -1)
						smallestPF[j] = i;
				}
			}
		}
		int n = arr.length;
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			hashSet.add(arr[i]);
		}

		DisjointSet dsu = new DisjointSet(100005);
		for (int i = 0; i < n; i++) {
			int curr = arr[i];
			while (curr != 1) {
				int s = smallestPF[curr];
				if (dsu.find(arr[i]) != dsu.find(s))
					dsu.union(arr[i], s);
				curr = curr / s;
			}
		}
		int freq[] = new int[100005];
		for (int i = 0; i < n; i++) {
			freq[dsu.find(arr[i])]++;
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i < 100005; i++) {
			ans = Math.max(ans, freq[i]);
		}
        return ans;
    }
    static class DisjointSet {
		int parent[];
		int size[];

		public DisjointSet(int n) {
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
			Arrays.fill(size, 1);
		}

		public int find(int node) {
			if (node == parent[node])
				return node;
			return parent[node] = find(parent[node]);
		}

		public void union(int u, int v) {
			int pu = find(u);
			int pv = find(v);
			if (pu == pv)
				return;

			if (size[pu] >= size[pv]) {
				parent[pv] = pu;
				size[pu] += size[pv];
			} else {
				parent[pu] = pv;
				size[pv] += size[pu];
			}
		}

		public int getSize(int node) {
			return size[node];
		}
	}
}