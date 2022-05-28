class Solution {
    public int missingNumber(int[] arr) {
        int xorA=0;int xorB=0;
        for(int i=0;i<arr.length;i++) xorA=xorA^arr[i];
        for(int i=0;i<=arr.length;i++) xorB=xorB^i;
        
        return xorA^xorB;
    }
}