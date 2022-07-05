class Solution {
    public int longestConsecutive(int[] arr) {
        int n=arr.length;
	    if(n==0) return 0;
		DisjointSet dsu=new DisjointSet(arr, n);
		HashSet<Integer> hashSet=new HashSet<>();
		int res=1;
		hashSet.add(arr[0]);
		for(int i=1;i<n;i++) {
			int curr=arr[i];int prev=arr[i]-1;int next=arr[i]+1;
			if(hashSet.contains(prev)) {
				int u=dsu.find(curr);
				int v=dsu.find(prev);
				dsu.union(u, v);
			}
			if(hashSet.contains(next)) {
				int u=dsu.find(curr);
				int v=dsu.find(next);
				dsu.union(u, v);
			}
			
			int parent=dsu.find(curr);
			res=Math.max(res, dsu.size.get(parent));
			hashSet.add(arr[i]);
		}
		
		
		return res;
    }
}

class DisjointSet{
		HashMap<Integer,Integer> parent;
		HashMap<Integer, Integer> size;
		
		public DisjointSet(int arr[],int n) {
			parent=new HashMap<>();
			size=new HashMap<>();
			for(int i=0;i<n;i++) {
				parent.putIfAbsent(arr[i],arr[i]);
				size.putIfAbsent(arr[i], 1);
			}
		}
		
		public int find(int node) {
			if(parent.get(node)==node) return node;
			parent.put(node,find(parent.get(node)));
			return parent.get(node);
		}
		
		public void union(int u,int v) {
			int pu=parent.get(u);
			int pv=parent.get(v);
			
			if(pu==pv) return;
			
			if(size.get(pu)<=size.get(pv)) {
				parent.put(pu, pv);
				size.put(pv,size.get(pv)+size.get(pu));
			}else {
				parent.put(pv, pu);
				size.put(pu,size.get(pu)+size.get(pv));
			}
		}
	}