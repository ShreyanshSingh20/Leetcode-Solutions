class Solution {
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
		List<List<Integer>> g=new ArrayList<>();
		for(int i=0;i<n;i++) g.add(new ArrayList<>());
		for(int i=0;i<n;i++) {
			if(i==0) continue;
			addEdge(g,i,parent[i]);
		}
		char c[]=s.toCharArray();
		boolean vis[]=new boolean[n];
		dfs(g, vis, 0, c);
		return (res);
    }
    
    public void addEdge(List<List<Integer>> g,int u,int v) {
		g.get(u).add(v);
		g.get(v).add(u);
	}
	
	public int res=1;
	public int dfs(List<List<Integer>> g,boolean vis[],int curr,char c[]) {
		vis[curr]=true;
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		for(int child:g.get(curr)) {
			if(vis[child]==false) {
				int num=dfs(g, vis, child, c);
				if(c[curr]!=c[child]) pq.add(num);
			}
		}
		
		int max=pq.isEmpty()?0:pq.poll();
		int secmax=pq.isEmpty()?0:pq.poll();
		res=Math.max(max+secmax+1,res);
		
		return max+1;
		
	}
}