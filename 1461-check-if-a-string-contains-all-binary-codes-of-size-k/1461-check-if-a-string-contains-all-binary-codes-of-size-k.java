class Solution {
    public boolean hasAllCodes(String str, int k) {
        char c[]=str.toCharArray();
		int x=(int)Math.pow(2, k)-1;
		int total=(int)Math.pow(2, k);
		StringBuilder s=new StringBuilder();
		int l=0;int cnt=0;HashSet<Integer> set=new HashSet<>();
		for(int r=0;r<c.length;r++) {
			s.append(c[r]);
			if(r-l+1==k) {
                // System.out.println(s.toString());
				int num=Integer.parseInt(s.toString(), 2);
                s.deleteCharAt(0);
				l++;
				if(set.contains(num)) continue;
				if((num|x)==x) cnt++;
				set.add(num);
			}
		}
		return (cnt==total);
    }
}