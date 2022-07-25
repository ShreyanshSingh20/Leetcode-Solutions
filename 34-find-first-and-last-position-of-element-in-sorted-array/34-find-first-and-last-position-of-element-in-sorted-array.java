class Solution {
    public int[] searchRange(int[] arr, int target) {
        
        int l=0;int r=arr.length-1;
        
        int res1=-1;
        int res2=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=target){
                if(arr[mid]==target) res1=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        l=0;r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]<=target){
                if(arr[mid]==target) res2=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        
        return new int[]{res1,res2};
    }
}