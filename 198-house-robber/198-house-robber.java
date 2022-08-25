class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        Integer dp[]=new Integer[n+1];
        return solver(arr,0,dp);
    }
    
    public int solver(int arr[],int i,Integer dp[]){
        
        if(i>=arr.length) return 0;
        
        if(dp[i]!=null) return dp[i];
        
        int res=Math.max(arr[i]+solver(arr,i+2,dp),solver(arr,i+1,dp));
        
        return dp[i]=res;
    }
}