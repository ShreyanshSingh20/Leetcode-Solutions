class Solution {
    public long waysToBuyPensPencils(int total, int pens, int pencils) {
		
		int limit=total/pencils;
		long res=0;
		for(int i=0;i<=limit;i++) {
			long rem=total-i*(pencils);
			if(rem>=0) {
				res+=((long)rem/(long)pens)+(long)1;
			}
		}
		
		return (res);
    }
}