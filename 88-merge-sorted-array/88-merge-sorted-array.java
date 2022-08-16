class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int l=m-1;int r=n-1;
        int pt=m+n-1;
        while(l>=0&&r>=0){
            if(nums1[l]>=nums2[r]){
                nums1[pt]=nums1[l];
                l--;
            }else{
                nums1[pt]=nums2[r];
                r--;
            }
            pt=pt-1;
        }
        
        while(l>=0){
            nums1[pt]=nums1[l];
            l--;pt--;
        }
        
        while(r>=0){
            nums1[pt]=nums2[r];
            r--;pt--;
        }
        
    }
}