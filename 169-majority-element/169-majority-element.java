class Solution {
    public int majorityElement(int[] arr) {
        
        int n=arr.length;
        int cnt=0;long elem=Long.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            if(cnt==0) elem=arr[i];
            if(elem==arr[i]) cnt++;
            else cnt--;
        }
        
        return (int)elem;
        
    }
}