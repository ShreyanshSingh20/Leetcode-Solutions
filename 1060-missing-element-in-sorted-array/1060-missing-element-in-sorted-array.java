class Solution {
    public int missingElement(int[] arr, int k) {
        int n=arr.length;
        int curr=arr[0];
        for(int i=1;i<n;i++){
            int diff=arr[i]-arr[i-1]-1;
            if(diff<k) k-=diff;
            else return curr+k;
            
            curr=arr[i];
        }
        
        return curr+k;
    }
}