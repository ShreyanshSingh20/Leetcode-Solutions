class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        HashSet<Integer> h=new HashSet<>();
		HashSet<Integer> prev=new HashSet<>();
		HashSet<Integer> res=new HashSet<>();
		prev.add(arr[0]);
		res.add(arr[0]);
		for(int i=1;i<n;i++) {
			h=new HashSet<>();
			h.add(arr[i]);
			Iterator<Integer> eIterator=prev.iterator();
			while(eIterator.hasNext()) {
				int x=eIterator.next();
				int or=x|arr[i];
				h.add(or);
			}
			
			res.addAll(prev=h);
		}
		return (res.size());
    }
}