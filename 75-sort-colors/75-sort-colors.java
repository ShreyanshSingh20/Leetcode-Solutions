class Solution {
    public void sortColors(int[] arr) {
        
        int n=arr.length;
        int l=0;int h=n-1;int mid=0;
        while(mid<=h){
            if(arr[mid]==0){
                swap(arr,l,mid);
                l++;mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                swap(arr,mid,h);
                h--;
            }
        }
        
    }
    
    public void swap(int arr[],int l,int h){
        int temp=arr[l];
        arr[l]=arr[h];
        arr[h]=temp;
    }
}