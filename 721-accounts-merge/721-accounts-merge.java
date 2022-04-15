class Solution {
    public List<List<String>> accountsMerge(List<List<String>> list) {
        int n=list.size();
		
		DSU dsu=new DSU(n);
		HashMap<String,Integer> parent=new HashMap<String, Integer>();
		for(int i=0;i<n;i++) {
			for(int j=1;j<list.get(i).size();j++) {
				String email=list.get(i).get(j);
				if(parent.containsKey(email)) {
					int preParent=parent.get(email);
					dsu.union(i, preParent);
				}else {
					parent.put(email,i);
				}
			}
		}
		
		HashMap<Integer,HashSet<String>> res=new HashMap<>();
		for(int i=0;i<n;i++) {
			int par=dsu.find(i);
			res.putIfAbsent(par, new HashSet<>());
			HashSet<String> currSet=res.get(par);
			for(int j=1;j<list.get(i).size();j++) {
				currSet.add(list.get(i).get(j));
			}
			res.put(par,currSet);
		}
		
		
		List<List<String>> finres=new ArrayList<List<String>>();
		for(int ind:res.keySet()) {
			List<String> currList=new ArrayList<>();
			if(res.containsKey(ind)) {
				currList.addAll(res.get(ind));
			}
			
			Collections.sort(currList);
			currList.add(0,list.get(ind).get(0));
			finres.add(currList);
		}
        
        return finres;
    }
    
     class DSU{
		int parent[];
		int size[];
		
		public DSU(int n) {
			parent=new int[n];
			size=new int[n];
			for(int i=0;i<n;i++) {
				parent[i]=i;
			}
			Arrays.fill(size, 1);
		}
		
		public int find(int node) {
			if(parent[node]==node) return node;
			return parent[node]=find(parent[node]);
		}
		
		public void union(int u,int v) {
			int pu=find(u);
			int pv=find(v);
			if(pu==pv) return;
			
			if(size[pu]<=size[pv]) {
				parent[pu]=pv;
				size[pv]+=size[pu];
			}else {
				parent[pv]=pu;
				size[pu]+=size[pv];
			}
		}
	}
}