class Solution {
    public int divide(int dividend, int divisor) {
        long res=(long)dividend/(long)divisor;
        if(res>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)res;
    }
}