class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        
        int left[]=new int[n];
        int right[]=new int[n];
        
        int len=1;
        left[0]=len;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                len++;
            }else{
                len=1;
            }
            left[i]=len;
        }
        
        len=1;
        right[n-1]=len;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                len++;
            }else{
                len=1;
            }
            right[i]=len;
        }
        
        int res=0;
        for(int i=0;i<n;i++){
            res+=Math.max(left[i],right[i]);
        }
        
        return res;
    }
}