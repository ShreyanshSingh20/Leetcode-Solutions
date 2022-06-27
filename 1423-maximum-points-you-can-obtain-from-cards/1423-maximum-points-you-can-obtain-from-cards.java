class Solution {
    public int maxScore(int[] arr, int k) {
        
        int n = arr.length;

		int l=0;int min=Integer.MAX_VALUE;
        int sum=0;int totalSum=0;
        for(int r=0;r<n;r++){
            totalSum+=arr[r];
            sum+=arr[r];
            if(r-l+1==n-k){
                min=Math.min(min,sum);
                sum-=arr[l];
                l++;
            }
        }
        if(n-k==0) return totalSum;
        return totalSum-min;
    }
}
//   0   1   2   3  4  5  6
//   1   2   3   4  5  6  1
// p 1   3   6  10 15 21 22
// s 22  21  19 16 12 7  1
      
// 12  (1+7)  (3+1) 6
// 12    8     4    6