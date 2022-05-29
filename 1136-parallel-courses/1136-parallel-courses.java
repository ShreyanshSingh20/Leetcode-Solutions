class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int e=relations.length;
		List<List<Integer>> g=new ArrayList<>();
		for(int i=0;i<n;i++) g.add(new ArrayList<>());
		int deg[]=new int[n];
		for(int i=0;i<e;i++) {
			deg[relations[i][1]-1]++;
			addEdge(g,relations[i][0]-1,relations[i][1]-1);
		}
	
		if(dfs(g, n)) return -1;
		
		int res=topoSort(g, deg, n);
		return (res);
    }
    
    public void addEdge(List<List<Integer>> g,int u,int v) {
		g.get(u).add(v);
	}
	
	public boolean dfs(List<List<Integer>> g,int n) {
		boolean vis[]=new boolean[n];
		boolean backEdge[]=new boolean[n];
		for(int i=0;i<n;i++) {
			if(vis[i]==false) {
				if(dfsHelper(g,i,n,vis,backEdge)) return true;
			}
		}
		return false;
	}
	
	public boolean dfsHelper(List<List<Integer>> g,int source,int n,boolean vis[],boolean backEdge[]) {
		vis[source]=true;
		backEdge[source]=true;
		for(int x:g.get(source)) {
			if(vis[x]==false) {
				if(dfsHelper(g, x, n, vis, backEdge)) return true;
			}else {
				if(backEdge[x]==true) return true;
			}
		}
		backEdge[source]=false;
		return false;
	}
	
	
	public int topoSort(List<List<Integer>> g,int deg[],int n) {
		Queue<Integer> queue=new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			if(deg[i]==0) queue.add(i);
		}
		
		int res=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				int curr=queue.poll();
				for(int x:g.get(curr)) {
					deg[x]--;
					if(deg[x]==0) queue.add(x);
				}
			}
			res++;
		}
		
		return res;
	}

	
}