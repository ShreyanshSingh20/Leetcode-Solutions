class Solution {
    public boolean hasAllCodes(String str, int k) {
        char c[]=str.toCharArray();
		int need=(1<<k);
        boolean got[]=new boolean[need];
        int allOne=need-1;
        int hashValue=0;
		for(int r=0;r<c.length;r++) {
			hashValue=((hashValue<<1)&(allOne))|(c[r]-'0');
            if(r>=k-1&&!got[hashValue]){
                got[hashValue]=true;
                need--;
                if(need==0) return true;
            }
		}
		return false;
    }
}