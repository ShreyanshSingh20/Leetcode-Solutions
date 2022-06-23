class Solution {
    public int longestSubsequence(String s, int k) {
        char c[]=s.toCharArray();
        int n=c.length;
        int cnt[]=new int[n];
        int cnt0=0;
        for(int i=n-1;i>=0;i--){
            if(c[i]=='0') cnt0++;
            cnt[i]=cnt0;
        }
        
        int len=cnt[0];
        
        int value=0;int appended=0;
        for(int i=n-1;i>=0;i--){
            if(c[i]=='1'){
                int power=cnt[i]+appended;
                value+=Math.pow(2,power);
                if(value>k) return len;
                appended++;
                len++;
            }
        }
        
        return len;
    }
}