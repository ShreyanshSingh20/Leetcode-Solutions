class Solution {
    public int minSwaps(int[] arr) {
        int n=arr.length;
        int cnt=0;
        for(int x:arr)
            if(x==1)
                cnt++;
        
        int l=0;int currOnes=0;int res=Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            if(arr[r]==1) currOnes++;
            if(r-l+1==cnt){
                res=Math.min(res,cnt-currOnes);
                if(arr[l]==1) currOnes--;
                l++;
            }
        }
        
        return res==Integer.MAX_VALUE?0:res;
    }
}