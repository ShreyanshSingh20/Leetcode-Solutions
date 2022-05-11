class Solution {
    public List<String> findStrobogrammatic(int n) {
        return solver(n, n);
    }
    
    
    public char pair[][]= {
			{'0','0'},
			{'1','1'},
			{'8','8'},
			{'6','9'},
			{'9','6'},
	};
	
	
	public List<String> solver(int n,int finLength){
		
		if(n==0) return new ArrayList<>(List.of(""));
		
		if(n==1) return new ArrayList<>(List.of("0","1","8"));
		
		List<String> prev=solver(n-2, finLength);
		List<String> curr=new ArrayList<>();
		
		for(String prevStr:prev) {
			for(char p[]:pair) {
				if(n!=finLength||p[0]!='0') {
					curr.add(p[0]+prevStr+p[1]);
				}
			}
		}
		
		return curr;
	}

}