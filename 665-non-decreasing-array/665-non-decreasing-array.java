class Solution {
    public boolean checkPossibility(int[] arr) {
        int n=arr.length;int violations=0;
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                violations++;
                if(violations>1) return false;
                if(i==1){
                    arr[i-1]=arr[i];
                }else{
                    if(arr[i]>=arr[i-2]) arr[i-1]=arr[i];
                    else arr[i]=arr[i-1];
                }
            }
        }
        
        return true;
    }
}