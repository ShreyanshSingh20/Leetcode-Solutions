class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n=rolls.length;
        int res=0;
        HashSet<Integer> set=new HashSet<>();
        
        for(int i=0;i<n;i++){
            set.add(rolls[i]);
            if(set.size()==k){
                res++;
                set.clear();
            }
        }
        
        return res+1;
    }
}