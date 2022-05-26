public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int res=0;
        while(n!=0){
            res++;
            n=n&(n-1);
        }
        return res;
    }
    
    public boolean setBit(int n,int i){
        return ((1<<i)&n)!=0?true:false;
    }
}