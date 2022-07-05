class Solution {
    public int superEggDrop(int e, int f) {
        int dp[][]=new int[e+1][f+1];
        for(int x[]:dp) Arrays.fill(x,-1);
        return solver(e,f,dp);
    }
    
     public int solver(int e,int f,int dp[][]){
        
        if(f==0) return 0;
        if(f==1) return 1;
        if(e==0) return 0;
        if(e==1) return f;
        
        if(dp[e][f]!=-1) return (int)dp[e][f];
        
        int res=Integer.MAX_VALUE;
        int low=1;int high=f;
        while(low<=high){
            int mid=(low+high)/2;
            int down=solver(e-1,mid-1,dp);
            int up=solver(e,f-mid,dp);
            int temp=1+Math.max(up,down);
            if(up<down){
                high=mid-1;
            }else{
                low=mid+1;
            }
            res=Math.min(res,temp);
        }
        
        return dp[e][f]=res;
    }
    
}