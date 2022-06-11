class Solution {
    public int minOperations(int[] arr, int x) {
        int n=arr.length;
		
		
		long psum[]=new long[n];
		psum[0]=arr[0];
		for(int i=1;i<n;i++) psum[i]=psum[i-1]+arr[i];
		
		long ssum[]=new long[n];
		ssum[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--) ssum[i]=ssum[i+1]+arr[i];
		
		HashMap<Long, Integer> pmap=new HashMap<>();
		HashMap<Long,Integer> smap=new HashMap<>();
		
		for(int i=0;i<n;i++) pmap.putIfAbsent(psum[i], i);
		for(int i=n-1;i>=0;i--) smap.putIfAbsent(ssum[i], i);
		
		int res=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			long curr=psum[i];
			long key=x-curr;
			if(smap.containsKey(key)) {
				int left=i;
				int right=smap.get(key);
				if(left<right) res=Math.min(res,(n-right)+(left+1));
			}
		}
		
		for(int i=0;i<n;i++) {
			if(psum[i]==x) res=Math.min(res, i+1);
		}
		for(int i=n-1;i>=0;i--) {
			if(ssum[i]==x) res=Math.min(res, n-i);
		}
		
		return (res==Integer.MAX_VALUE?-1:res);
    }
}