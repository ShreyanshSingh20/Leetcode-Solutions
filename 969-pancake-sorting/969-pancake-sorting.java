class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> res=new ArrayList<>();
        int limit=arr.length-1;
        while(limit>=0){
            int maxInd=findMax(arr,limit);
            res.add(maxInd+1);
            flip(arr,maxInd);
            res.add(limit+1);
            flip(arr,limit);
            limit--;
        }
        return res;
    }
    
    public void flip(int arr[],int r){
        int i=0;
        while(i<=r){
            int temp=arr[i];
            arr[i]=arr[r];
            arr[r]=temp;
            i++;r--;
        }
    }
    
    public int findMax(int arr[],int limit){
        int max=Integer.MIN_VALUE;
        int maxInd=-1;
        for(int i=0;i<=limit;i++){
            if(arr[i]>max){
                max=arr[i];
                maxInd=i;
            }
        }
        return maxInd;
    }
}