class Solution {
    public int superpalindromesInRange(String lefts, String rights) {
        long left=Long.parseLong(lefts);
		long right=Long.parseLong(rights);
		List<Long> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			nums.add((long) i);
		for (int i = 1; i < 10000; i++) {
			String firstHalf = i + "";
			String secondHalf = new StringBuilder(firstHalf).reverse().toString();
			nums.add(Long.parseLong(firstHalf + secondHalf));
			for (int j = 0; j < c.length; j++) {
				nums.add(Long.parseLong(firstHalf + c[j] + secondHalf));
			}
		}
		
		int res = 0;
		for (long x : nums) {
			long sqr = x * x;
			if (!checkPalin(sqr + ""))
				continue;
			if (sqr >= left && sqr <= right)
				res++;
		}
		return (res);
    }
    
   public boolean checkPalin(String s) {
		int l=0;int r=s.length()-1;
		while(l<=r) {
			if(s.charAt(l)!=s.charAt(r)) return false;
			l++;r--;
		}
		return true;
	}
	
	public char c[]= {'0','1','2','3','4','5','6','7','8','9'};
}