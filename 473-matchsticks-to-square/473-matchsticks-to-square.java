class Solution {
    public boolean makesquare(int[] arr) {
        int k=4;
        int n=arr.length;
        
        int totalSum=0;
        for(int x:arr) totalSum+=x;
        if(totalSum%k!=0) return false;
        totalSum/=k;
        
        HashMap<Integer,Boolean> dp=new HashMap<>();
        return rec(0,0,0,totalSum,arr,k,-1,dp);
    }
    
    public boolean rec(int currSum,int mask,int countOfSets,int totalSum,int arr[],int k,int prevInd,
                      HashMap<Integer,Boolean> dp){
        
        if(countOfSets==k-1) return true;
        
        if(currSum>totalSum) return false;
        
        if(dp.containsKey(mask)) return dp.get(mask);
        
        if(currSum==totalSum){
            boolean ans=rec(0,mask,countOfSets+1,totalSum,arr,k,-1,dp);
            dp.put(mask,ans);
            return ans;
        }
        
        for(int i=prevInd+1;i<arr.length;i++){
            if((mask&(1<<i))==0){
                boolean ans=rec(currSum+arr[i],mask|(1<<i),countOfSets,totalSum,arr,k,0,dp);
                dp.put(mask,ans);
                if(ans==true) return true;
            }
        }
        
        dp.put(mask,false);
        return false;
    }
}