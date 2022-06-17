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
        //if the character is already mapped to a string
		if(dp.containsKey(c)) {
			String str=dp.get(c);
			
            //check if this character can again be mapped to the same string..if no return false
			if(!s.startsWith(str,j)) return false;
			
            //if yes, move to the next character and to the next part of the string
			return solver(pattern, i+1, s, j+str.length(), dp, set);
		}
		
        //if the character has not yet been mapped then try different substrings with which it can be mapped
		for(int k=j;k<s.length();k++) {
			String subString=s.substring(j, k+1);
			
            //if this substring had already been mapped then skip this as this will result in collisions
			if(set.contains(subString)) continue;
			
            //update the dp state 
			dp.put(c, subString);
			set.add(subString);
			
            //check if I can get an answer with this configuration, if yes return true
			if(solver(pattern, i+1, s, k+1, dp, set)) return true;
			
            //if no, then undo the configuration and move to the next substring in the next iteration in this loop
			dp.remove(c);
			set.remove(subString);
		}
		
        //We can't do anything even after all these trys so just give up and return false
		return false;
	}
}