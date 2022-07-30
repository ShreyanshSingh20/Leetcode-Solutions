class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int n=words1.length;
		int m=words2.length;
		
		//gathering minimum requirements
		int minReq[]=new int[26];
		for(int i=0;i<m;i++) {
			char c[]=words2[i].toCharArray();
			int freq[]=new int[26];
			for(int j=0;j<c.length;j++) {
				freq[c[j]-'a']++;
			}
			
			for(int j=0;j<26;j++) {
				minReq[j]=Math.max(minReq[j], freq[j]);
			}
		}
		
		List<String> res=new ArrayList<String>();
		
		//checking each word one by one for minimum requirement
		for(int i=0;i<n;i++) {
			char c[]=words1[i].toCharArray();
			int freq[]=new int[26];
			for(int j=0;j<c.length;j++) {
				freq[c[j]-'a']++;
			}
			
			boolean isUniversal=true;
			for(int j=0;j<26;j++) {
				if(minReq[j]>freq[j]) {isUniversal=false; break;}
			}
			
			if(isUniversal) res.add(words1[i]);
		}
        
        return res;
    }
}