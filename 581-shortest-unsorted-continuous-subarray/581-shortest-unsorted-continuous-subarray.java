class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int n=arr.length;
        int start=-1;int end=-1;
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                start=i-1;
                break;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                end=i+1;
                break;
            }
        }
        
        if(start==-1&&end==-1) return 0;
        
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        
        for(int i=start;i<=end;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        
        int a=-1;int b=-1;
        
        for(int i=0;i<n;i++){
            if(arr[i]>min) {a=i; break;} 
        }
        
        for(int i=n-1;i>=0;i--){
            if(arr[i]<max) {b=i;break;}
        }
        
        return b-a+1;
    }
}