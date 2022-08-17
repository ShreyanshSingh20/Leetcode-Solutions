class Solution {
    public int removeDuplicates(int[] arr) {
        
        int n=arr.length;
        int i=0;
        while(i<n){
            while(i+1<n&&arr[i]==arr[i+1]){
                arr[i]=400;
                i++;
            }
            i++;
        }
        
        int left=0;
        while(left<n&&arr[left]!=400){
            left++;
        }
        
        if(left==n) return n;
        
        for(int r=left+1;r<n;r++){
            if(arr[r]!=400){
                int temp=arr[left];
                arr[left]=arr[r];
                arr[r]=temp;
                left++;
            }
        }
        
        int k=0;
        for(int j=0;j<n;j++){
            if(arr[j]!=400) k++;
            else break;
        }
        
        return k;
        
    }
}