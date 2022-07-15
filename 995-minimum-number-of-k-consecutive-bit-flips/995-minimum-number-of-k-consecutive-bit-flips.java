class Solution {
    public int minKBitFlips(int[] arr, int k) {
        
        int n=arr.length;
        int isFlipped[]=new int[n];
        int flipped=0;
        int res=0;
        
        for(int i=0;i<n;i++){
            if(i>=k){
                flipped=flipped^(isFlipped[i-k]);
            }
            
            if(arr[i]==flipped){
                if(i+k>arr.length) return -1;
                isFlipped[i]=1;
                flipped=flipped^1;
                res++;
            }
        }
        
        return res;
    }
}