class Solution {
    public int findDuplicate(int[] arr) {
        int n=arr.length;
        while(arr[arr[0]]!=arr[0]){
            int temp=arr[arr[0]];
            arr[arr[0]]=arr[0];
            arr[0]=temp;
        }
        
        return arr[0];
    }
}