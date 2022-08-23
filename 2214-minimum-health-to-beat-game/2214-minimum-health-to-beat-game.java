class Solution {
    public long minimumHealth(int[] damage, int armor) {
        
        long health=1;
        
        int max=Integer.MIN_VALUE;
        for(int x:damage){
            max=Math.max(max,x);
            health+=x;
        }
        
        health-=Math.min(armor,max);
        return health;
    }
}