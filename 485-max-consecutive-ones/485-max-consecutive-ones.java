class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        
        int n=arr.length;
        int cnt=0;int max=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1) cnt++;
            else{
                max=Math.max(cnt,max);
                cnt=0;
            }
        }
        
        max=Math.max(max,cnt);
        return max;
    }
}