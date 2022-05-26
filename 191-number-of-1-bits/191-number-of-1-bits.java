public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int res=0;
        for(int i=31;i>=0;i--){
            if(setBit(n,i)) res++;
        }
        return res;
    }
    
    public boolean setBit(int n,int i){
        return ((1<<i)&n)!=0?true:false;
    }
}