class Solution {
    public int combinationSum4(int[] arr, int target) {
        
        Integer dp[][]=new Integer[target+1][arr.length+1];
        return solver(arr,target,0,dp);
    }
    
    public int solver(int arr[],int target,int i,Integer dp[][]){
        
        if(target==0) return 1;
        if(target<0) return 0;
        
        if(dp[target][i]!=null) return dp[target][i];
        
        int res=0;
        for(int j=0;j<arr.length;j++){
            res+=solver(arr,target-arr[j],j,dp);
        }
        return dp[target][i]=res;
    }
}