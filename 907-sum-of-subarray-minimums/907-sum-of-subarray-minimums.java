class Solution {
    
    public long mod = 1_000_000_007;
    
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];
		Stack<Integer> a = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!a.isEmpty() && arr[a.peek()] >= arr[i]) {
				a.pop();
			}
			left[i]=a.isEmpty()?i+1:i-a.peek();
			a.push(i);
		}

		Stack<Integer> b = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!b.isEmpty() && arr[b.peek()] > arr[i]) {
				b.pop();
			}
			right[i]=b.isEmpty()?n-i:b.peek()-i;
			b.push(i);
		}
        
        // for(int x:left) System.out.print(x+" ");
        // System.out.println();
        // for(int x:right) System.out.print(x+" ");
        // System.out.println();

		long res = 0;
		for (int i = 0; i < n; i++) {
			int l=left[i];
            int r=right[i];
            res=add(res,mul(arr[i],mul(l,r)));
		}

		return (int)(res);
    }
    
    public long add(long x, long y) {
		x += y;
		if (x >= mod)
			return (x % mod);
		return x;
	}
    
    public long mul(long x, long y) {
		return (x * y) % mod;
	}
}