class Solution {
    public int equalDigitFrequency(String s) {
        
        int mod=1_000_000_007;
        char c[]=s.toCharArray();
        int len=c.length;
        
        HashSet<Integer> hashes=new HashSet<>();
        
        for(int i=0;i<len;i++){
            int unique=0;
            int maxFreqCount=0;
            int freq[]=new int[10];
            int rollingHash=0;
            for(int j=i;j<len;j++){
                int dig=c[j]-'0';
                unique+= freq[dig]++ ==0?1:0;
                maxFreqCount=Math.max(maxFreqCount,freq[dig]);
                rollingHash=(rollingHash*11+dig+1)%mod;
                if(unique*maxFreqCount==j-i+1){
                    hashes.add(rollingHash);
                }
            }
        }
        
        return hashes.size();
    }
}