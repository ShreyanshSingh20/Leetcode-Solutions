class Solution {
    
    public int mod=1_000_000_007;
    
    public String longestDupSubstring(String s) {
            int l=1;int r=s.length()-1;
            int startIdx=-1;int len=-1;
            while(l<=r){
                int mid=(l+r)/2;
                int idx=solver(s,mid);
                if(idx!=-1){
                    if(mid>len){
                        len=mid;
                        startIdx=idx;
                    }
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }

        if(len==-1) return "";
        // System.out.println(startIdx);
        return s.substring(startIdx,startIdx+len);
    

    }
    
    public int solver(String s,int len){
        int l=0;int r=0;int p=11;
        long prevHash=0;
        HashMap<Long,List<Integer>> map=new HashMap<>();
        for(int i=0;i<len;i++) prevHash=add((s.charAt(i)-'a'),mul(prevHash,p));
        
        map.putIfAbsent(prevHash,new ArrayList<>());
        map.get(prevHash).add((len-1)-(len-1));
        // System.out.println(len-1+" "+prevHash);
        for(r=len;r<s.length();r++){
            int ch=s.charAt(l)-'a';
            int newch=s.charAt(r)-'a';
            long currHash=prevHash;
            currHash=sub(currHash,mul(ch,(long)bin_pow(p,len-1)));
            currHash=mul(currHash,p);
            currHash=add(currHash,newch);
            l++;
            
            int currStart=r-(len-1);
            if(map.containsKey(currHash)&&map.get(currHash).size()>0){
                for(int start:map.get(currHash)){
                    if(s.substring(start,start+len).equals(s.substring(currStart,currStart+len))) return currStart;
                }
            }
            
            map.putIfAbsent(currHash,new ArrayList<Integer>());
            map.get(currHash).add(currStart);
            prevHash=currHash;
        }
        
        return -1;
    }
    
    public long add(long x,long y){
        x+=y;
        if(x>=mod) return x%mod;
        return x;
    }
    
    public long mul(long x,long y){
        return (x*y)%mod;
    }
    
    public long bin_pow(long x, long p) {
		if (p == 0)
			return 1;
		if ((p & 1) != 0)
			return mul(x, bin_pow(x, p - 1));
		return bin_pow(mul(x, x), p / 2);
	}
    
    public long sub(long x, long y) {
		x -= y;
		if (x < 0)
			return (x + mod);
		return x;
	}
}