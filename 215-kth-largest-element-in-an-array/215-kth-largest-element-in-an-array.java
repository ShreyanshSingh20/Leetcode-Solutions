class Solution {
    public int findKthLargest(int[] nums, int k) {
        int pos[]=new int[10005];
        int neg[]=new int[10005];
        
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>=0) pos[nums[i]]++;
            else neg[Math.abs(nums[i])]++;
        }
        
        
        //traverse the pos freq array from the starting index
        for(int i=pos.length-1;i>=0;i--){
            if(k==0) return i;
            int minus=Math.min(k,pos[i]);
            k-=minus;
            if(k==0) return i;
        }
        
        
        //traverse the neg freq array from the last index
        for(int i=0;i<neg.length;i++){
            if(k==0) return -i;
            int minus=Math.min(k,neg[i]);
            k-=minus;
            if(k==0) return -i;
        }
        
        return -1;
    }
}