class Solution {
    public int findClosestNumber(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int diff=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<n;i++){
            int curr=Math.abs(arr[i]);
            if(curr<=diff){
                diff=curr;
                res=arr[i];
            }
        }
        return res;
    }
}