class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        //find total sum
        int totalSum=0;
        for(int x:arr) totalSum+=x;
        
        //find min Subarray sum
        int minSum=arr[0];int currMin=arr[0];
        for(int i=1;i<n;i++){
            currMin=Math.min(currMin+arr[i],arr[i]);
            minSum=Math.min(minSum,currMin);
        }
        
        //find max Subarray sum
        int maxSum=arr[0];int currMax=arr[0];
        for(int i=1;i<n;i++){
            currMax=Math.max(currMax+arr[i],arr[i]);
            maxSum=Math.max(currMax,maxSum);
        }
        
        if(totalSum==minSum) return maxSum;
        return Math.max(maxSum,totalSum-minSum);
    }
}