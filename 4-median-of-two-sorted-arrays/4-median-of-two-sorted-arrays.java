class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        
        int size1=arr1.length;
        int size2=arr2.length;
        
        if(size1>size2) return findMedianSortedArrays(arr2,arr1);
        
        int low=0;int high=size1;
        
        while(low<=high){
            int a=(low+high)/2;
            int b=((size1+size2+1)/2)-a;
            
            int l1=(a==0)?Integer.MIN_VALUE:arr1[a-1];
            int l2=(b==0)?Integer.MIN_VALUE:arr2[b-1];
            
            int r1=(a==size1)?Integer.MAX_VALUE:arr1[a];
            int r2=(b==size2)?Integer.MAX_VALUE:arr2[b];
            
            if(l1<=r2&&l2<=r1){
                if((size1+size2)%2==0){
                    int maxLeft=Math.max(l1,l2);
                    int minRight=Math.min(r1,r2);
                    return (maxLeft+minRight)/2.0;
                }else{
                    return (double)Math.max(l1,l2);
                }
            }else if(l1<=r2){
                low=a+1;
            }else{
                high=a-1;
            }
        }
        
        return 0.0;
    }
}