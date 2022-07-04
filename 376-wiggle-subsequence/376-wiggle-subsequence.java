class Solution {
    public int wiggleMaxLength(int[] arr) {
        int n=arr.length;
        
        int lastUp=1;
        int lastDown=1;
        
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                lastUp=1+lastDown;
            }else if(arr[i]<arr[i-1]){
                lastDown=1+lastUp;
            }
        }
        
        return Math.max(lastUp,lastDown);
    }
}