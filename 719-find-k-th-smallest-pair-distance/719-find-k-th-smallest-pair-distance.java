class Solution {
    public int smallestDistancePair(int[] arr, int k) {
        
        Arrays.sort(arr);
        
        int l=0;int r=arr[arr.length-1]-arr[0];
        
        while(l<r){
            int mid=l+(r-l)/2;
            if(enough(arr,mid,k)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        
        return l;
    }
    
    public boolean enough(int arr[],int mid,int k){
        
        int i=0;int j=0;int cnt=0;
        while(i<arr.length){
            while(j<arr.length&&arr[j]-arr[i]<=mid){
                j++;
            }
            cnt+=j-i-1;
            i++;
        }
        
        return cnt>=k;
    }
}