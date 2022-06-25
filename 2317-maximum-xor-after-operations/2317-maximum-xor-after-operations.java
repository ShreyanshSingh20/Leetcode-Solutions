class Solution {
    public int maximumXOR(int[] nums) {
        int res=0;
        for(int x:nums){
            for(int bit=31;bit>=0;bit--){
                if((x&(1<<bit))!=0) res=(res|(1<<bit));
            }
        }
        return res;
    }
}