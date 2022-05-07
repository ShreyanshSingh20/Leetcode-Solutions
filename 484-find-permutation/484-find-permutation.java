class Solution {
    public int[] findPermutation(String s) {
        char c[]=s.toCharArray();
		int n=c.length+1;
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=i+1;
		
		int l=0;int r=0;
		while(r<c.length) {
			if(c[r]=='I') {
				reverse(arr,l,r);
				l=r+1;
				r++;
				continue;
			}
			r++;
		}
		
		reverse(arr,l,r);
        
        return arr;
    }
    
    public void reverse(int arr[],int l,int r) {
		int templ=l;int tempr=r;
		while(templ<=tempr) {
			int temp=arr[templ];
			arr[templ]=arr[tempr];
			arr[tempr]=temp;
			templ++;tempr--;
		}
	}
}