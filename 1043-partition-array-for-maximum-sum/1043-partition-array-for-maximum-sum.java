class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer dp[]=new Integer[arr.length+1];
        return solver(arr,k,0,dp);
    }
    
    public int solver(int arr[],int k,int prev,Integer dp[]){
        
        if(prev==arr.length) return 0;
        
        if(dp[prev]!=null) return dp[prev];
        
        int end=Math.min(arr.length,prev+k);
        int currMax=arr[prev];
        int max=Integer.MIN_VALUE;
        for(int i=prev;i<end;i++){
            currMax=Math.max(currMax,arr[i]);
            int cnt=i-prev+1;
            int a=(cnt)*currMax;
            max=Math.max(max,a+solver(arr,k,i+1,dp));
        }
        
        return dp[prev]=max;
    }
}