class Solution {
    public int maxOperations(int[] arr, int k) {
        //number of pairs whose sum is equal to k
        Arrays.sort(arr);
        int cnt=0;
        int l=0;int r=arr.length-1;
        while(l<r){
            if(arr[l]+arr[r]==k) {l++;r--; cnt++;}
            else if(arr[l]+arr[r]>k) r--;
            else if(arr[l]+arr[r]<k) l++;
        }
        return cnt;
    }
    
}