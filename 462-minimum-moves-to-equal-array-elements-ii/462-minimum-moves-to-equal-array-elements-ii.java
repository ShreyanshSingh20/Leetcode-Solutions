class Solution {
    public int minMoves2(int[] arr) {
        int n=arr.length;
		
		Arrays.sort(arr);
		
		long psum[]=new long[n];
		psum[0]=arr[0];
		for(int i=1;i<n;i++) psum[i]=psum[i-1]+arr[i];
		
		long ssum[]=new long[n];
		ssum[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--) ssum[i]=ssum[i+1]+arr[i];
		
		
		
		
		long res=Long.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
	
			long leftCal=0;
			long rightCal=0;
			
			leftCal=(i==0)?(long)0:((long)i*(long)arr[i]-psum[i-1]);
            rightCal=(i==n-1)?(long)0:(ssum[i+1]-(long)arr[i]*(long)(n-i-1));
			
			res=Math.min(res, leftCal+rightCal);
		}
		
		
		return (int)(res);
		
    }
}