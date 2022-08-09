class Solution {
    public int countOdds(int low, int high) {
        
        int max=Math.max(low,high);
        int min=Math.min(low,high);
        
        if((max%2==0&&min%2!=0)||(max%2!=0&&min%2==0)){
            int len=max-min+1;
            return len/2;
        }else if(max%2==0&&min%2==0){
            return (max-min+1)/2;
        }else if(max%2!=0&&min%2!=0){
            int len=max-min+1;
            return (int)Math.ceil((double)len/2.0);
        }
        
        return 0;
    }
}