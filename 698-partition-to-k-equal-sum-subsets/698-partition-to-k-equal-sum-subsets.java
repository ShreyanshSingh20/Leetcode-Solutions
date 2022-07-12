class Solution {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        
        Arrays.sort(arr);
        reverse(arr);
        
        int totalSum=0;
        for(int x:arr) totalSum+=x;
        
        if(totalSum%k!=0) return false;
        totalSum=totalSum/k;
        
        HashMap<Integer,Boolean> dp=new HashMap<>();
        return rec(0,0,0,totalSum,arr,k,-1,dp);
        
    }
    
    public boolean rec(int currSum,int mask,int cnt,int totalSum,int arr[],int k,int prevInd,HashMap<Integer,Boolean> dp){
        
        if(cnt==k-1) return true;
        
        if(currSum>totalSum) return false;
        
        if(dp.containsKey(mask)) return dp.get(mask);
        
        if(currSum==totalSum){
            boolean ans= rec(0,mask,cnt+1,totalSum,arr,k,-1,dp);
            dp.put(mask,ans);
            return ans;
        }
        
        boolean ans=false;
        for(int i=prevInd+1;i<arr.length;i++){
            if((mask&(1<<i))==0){
                ans=(rec(currSum+arr[i],mask|(1<<i),cnt,totalSum,arr,k,i,dp));
                if(ans==true){
                    dp.put(mask,ans);
                    return ans;
                }
            }
        }
        
            dp.put(mask,ans);
            return ans;
    }
    
    public void reverse(int arr[]){
        int l=0;int r=arr.length-1;
        while(l<=r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;r--;
        }
    }
    
}