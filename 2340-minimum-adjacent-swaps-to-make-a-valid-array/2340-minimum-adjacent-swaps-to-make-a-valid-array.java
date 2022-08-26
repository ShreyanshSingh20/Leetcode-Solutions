class Solution {
    public int minimumSwaps(int[] arr) {
        
        int minElem=Integer.MAX_VALUE;
        int maxElem=Integer.MIN_VALUE;
        int minInd=-1;int maxInd=-1;
        
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>maxElem){
                maxElem=arr[i];
                maxInd=i;
            }
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<minElem){
                minElem=arr[i];
                minInd=i;
            }
        }
        
        return Math.min(max(arr,maxInd),min(arr,minInd));
    }
    
    public int max(int nums[],int ind){
        
        int arr[]=nums.clone();
        
        int swaps=0;
        while(ind+1<arr.length){
            int temp=arr[ind+1];
            arr[ind+1]=arr[ind];
            arr[ind]=temp;
            swaps++;
            ind++;
        }
        
        int minElem=Integer.MAX_VALUE;
        int minInd=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<minElem){
                minElem=arr[i];
                minInd=i;
            }
        }
        
        while(minInd-1>=0){
            int temp=arr[minInd-1];
            arr[minInd-1]=arr[minInd];
            arr[minInd]=temp;
            swaps++;
            minInd--;
        }
        
        return swaps;
    }
    
    
    public int min(int nums[],int ind){
        int arr[]=nums.clone();
        
        int swaps=0;
        while(ind-1>=0){
            int temp=arr[ind-1];
            arr[ind-1]=arr[ind];
            arr[ind]=temp;
            swaps++;
            ind--;
        }
        
        int maxElem=Integer.MIN_VALUE;
        int maxInd=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxElem){
                maxElem=arr[i];
                maxInd=i;
            }
        }
        
        while(maxInd+1<arr.length){
            int temp=arr[maxInd+1];
            arr[maxInd+1]=arr[maxInd];
            arr[maxInd]=temp;
            swaps++;
            maxInd++;
        }
        
        return swaps;
    }
}