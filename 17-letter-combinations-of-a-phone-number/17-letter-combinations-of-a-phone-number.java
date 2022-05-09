class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        char c[]=digits.toCharArray();
		List<String> res=new ArrayList<>();
		solver(c, 0, res, new StringBuilder());
        return res;
    }
    
    public String[] arr= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
	
	public void solver(char c[],int i,List<String> res,StringBuilder s) {
		
		if(i==c.length) {
			res.add(s.toString());
			return;
		}
		
		int ind=c[i]-'0';
		for(int j=0;j<arr[ind].length();j++) {
			s.append(arr[ind].charAt(j));
			solver(c, i+1, res, s);
			if(s.length()>0) s.deleteCharAt(s.length()-1);
		}
	}
}