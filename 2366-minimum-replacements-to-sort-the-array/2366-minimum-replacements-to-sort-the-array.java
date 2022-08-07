class Solution {
    public long minimumReplacement(int[] arr) {
        
        int n=arr.length;int prev=arr[n-1];
        long res=0;
        for(int i=n-2;i>=0;i--){
            int curr=arr[i];
            int times=curr/prev;
            if(curr%prev!=0) times++;
            if(curr%prev!=0){
                prev=curr/times;
            }
            res+=(times-1);
        }
        
        return res;
    }
}