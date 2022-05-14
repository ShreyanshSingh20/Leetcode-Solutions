class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    
		// intitializing the graph
		List<List<Pair>> g = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			g.add(new ArrayList<Pair>());

		// constructing the graph
		int e = times.length;
		for (int i = 0; i < e; i++)
			addEdge(g, times[i][0], times[i][1], times[i][2]);

		int source = k;
		int sp[] = Djikstra(g, source, n);
		if (sp.length == 1)
			return -1;
		else {
			int max = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++)
				max = Math.max(max, sp[i]);
			return max;
		}
    }
    
    

	public void addEdge(List<List<Pair>> g, int source, int destination, int time) {
		g.get(source).add(new Pair(destination, time));
	}

	public int[] Djikstra(List<List<Pair>> g, int source, int n) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int sp[] = new int[n + 1];
		Arrays.fill(sp, Integer.MAX_VALUE);
		sp[source] = 0;
		pq.add(new int[] { source, 0 });

		while (!pq.isEmpty()) {
			int curr[] = pq.poll();
			int currNode = curr[0];
			int currDist = curr[1];
			for (Pair next : g.get(currNode)) {
				int nextNode = next.dest;
				int weight = next.weight;
				if (currDist + weight < sp[nextNode]) {
					sp[nextNode] = currDist + weight;
					pq.add(new int[] { nextNode, sp[nextNode] });
				}
			}
		}

		boolean allRecieveSignal = true;
		for (int i = 1; i <= n; i++)
			if (sp[i] == Integer.MAX_VALUE)
				allRecieveSignal = false;

		if (!allRecieveSignal)
			return new int[] { 0 };
		return sp;
	}
}

class Pair {
		int dest;
		int weight;

		public Pair(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
}