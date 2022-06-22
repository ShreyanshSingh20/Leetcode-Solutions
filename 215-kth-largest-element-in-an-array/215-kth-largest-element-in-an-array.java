class Solution {
    public int findKthLargest(int[] arr, int k) {
        int n=arr.length;
        int left=0;
        int right=n-1;
        
        Random rand=new Random();
        
        while(left<=right){
            int randomIndexAsPivot=rand.nextInt(right-left+1)+left;
            
            int findPartitionIndex=partition(arr,left,right,randomIndexAsPivot);
            if(findPartitionIndex==n-k) return arr[n-k];
            else if(findPartitionIndex>n-k) right=findPartitionIndex-1;
            else left=findPartitionIndex+1;
        }
        
        return -1;
    }
    
    public int partition(int arr[],int left,int right,int pivotIndex){
        int pivotValue=arr[pivotIndex];
        swap(arr,right,pivotIndex);
        int i=left;
        
        for(int j=left;j<right;j++){
            if(arr[j]<=pivotValue){
                swap(arr,i,j);
                i++;
            }
        }
        
        swap(arr,right,i);
        
        return i;
    }
    
    public void swap(int arr[],int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}