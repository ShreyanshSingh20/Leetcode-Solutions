class Solution {
    public boolean hasGroupsSizeX(int[] arr) {
        int n=arr.length;
		int freq[]=new int[10001];
		for(int i=0;i<n;i++) freq[arr[i]]++;
		
		int gcd=0;
		for(int i=0;i<freq.length;i++) {
			if(freq[i]==0) continue;
			gcd=(int) gcd(gcd, freq[i]);
		}
		
		return gcd>=2;
    }
    
    public long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}