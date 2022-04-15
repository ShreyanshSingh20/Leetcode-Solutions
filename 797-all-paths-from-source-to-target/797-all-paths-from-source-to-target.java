class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			g.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			int s = graph[i].length;
			for (int j = 0; j < s; j++) {
				addEdge(g, i, graph[i][j]);
			}
		}
		ArrayList<Integer> reStrings = new ArrayList<>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		boolean vis[] = new boolean[n];
		dfs(g, 0, n, vis, reStrings,list);
		
        return list;
    }
    
    public void addEdge(ArrayList<ArrayList<Integer>> g, int u, int v) {
		g.get(u).add(v);
	}

    public int pt=-1;
	public void dfs(ArrayList<ArrayList<Integer>> g, int s, int n, boolean vis[],
			ArrayList<Integer> res,List<List<Integer>> finres) {
		vis[s] = true;
		res.add(s);
		if (s == n - 1) {
			pt++;
			finres.add(new ArrayList<Integer>());
			for(int i=0;i<res.size();i++) {
				finres.get(pt).add(res.get(i));
			}
			res.remove(res.size()-1);
			vis[s] = false;
			return;
		}
		for (int x : g.get(s)) {
			if (vis[x] == false) {
				dfs(g, x, n, vis, res,finres);
			}

		}
		res.remove(res.size()-1);
		vis[s] = false;
	}
}