class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character,String> dp=new HashMap<>();
		HashSet<String> set=new HashSet<>();
		return (solver(pattern, 0, s, 0, dp, set));
    }
    
    public boolean solver(String pattern,int i,String s,int j,HashMap<Character, String> dp,HashSet<String> set) {
		
		if(i==pattern.length()&&j==s.length()) return true;
		if(i==pattern.length()||j==s.length()) return false;
		
		char c=pattern.charAt(i);
		if(dp.containsKey(c)) {
			String str=dp.get(c);
			
			if(!s.startsWith(str,j)) return false;
			
			return solver(pattern, i+1, s, j+str.length(), dp, set);
		}
		
		for(int k=j;k<s.length();k++) {
			String subString=s.substring(j, k+1);
			
			if(set.contains(subString)) continue;
			
			dp.put(c, subString);
			set.add(subString);
			
			if(solver(pattern, i+1, s, k+1, dp, set)) return true;
			
			dp.remove(c);
			set.remove(subString);
		}
		
		return false;
	}
}