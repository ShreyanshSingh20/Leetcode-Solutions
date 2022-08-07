class Solution {
    public boolean validPartition(int[] arr) {
        int n=arr.length;
        Boolean dp[]=new Boolean[n+1];
        return solver(arr,0,n,dp);
    }
    
    public boolean solver(int arr[],int i,int n,Boolean dp[]){
        
        if(i>n) return false;
        if(i==n) return true;
        
        if(dp[i]!=null) return dp[i];
        
        boolean a=false;boolean b=false;boolean c=false;
        if(i+1<n&&arr[i]==arr[i+1]){
             a=solver(arr,i+2,n,dp);
        }
        
        if(i+1<n&&i+2<n&&arr[i]==arr[i+1]&&arr[i+1]==arr[i+2]){
            b=solver(arr,i+3,n,dp);
        }
        
        if(i+1<n&&i+2<n&&arr[i+1]-arr[i]==1&&arr[i+2]-arr[i+1]==1){
            c=solver(arr,i+3,n,dp);
        }
        
        return dp[i]=(a|b|c);
        
    }
    
}