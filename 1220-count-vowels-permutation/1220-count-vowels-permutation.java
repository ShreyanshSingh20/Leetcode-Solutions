class Solution {
    public long mod=1_000_000_007;
    public int countVowelPermutation(int n) {
        Long dp[][]=new Long[n+1][6];
        return (int)solver(0,n,5,dp);
    }
    
    
// a->e
//     e->a,i
//     i->a,e,o,u
//     o->i,u
//     u->a
    
    public char c[]={'a','e','i','o','u'};
    
    public long solver(int i,int n,int prev,Long dp[][]){
        
        if(i==n) return 1;
        
        if(dp[i][prev]!=null) return dp[i][prev];
        
        long res=0;
        for(int j=0;j<5;j++){
            if(prev==5) res=add(res,solver(i+1,n,j,dp));
            else{
                if(prev==0){
                    if(j==1) res=add(res,solver(i+1,n,j,dp));
                }else if(prev==1){
                    if(j==0||j==2) res=add(res,solver(i+1,n,j,dp));
                }else if(prev==2){
                    if(j!=2) res=add(res,solver(i+1,n,j,dp));
                }else if(prev==3){
                    if(j==2||j==4) res=add(res,solver(i+1,n,j,dp));
                }else if(prev==4){
                    if(j==0) res=add(res,solver(i+1,n,j,dp));
                }
            }
        }
        
        return dp[i][prev]=res;
    }
    
    public long add(long x,long y){
        x+=y;
        if(x>=mod) return x%mod;
        return x;
    }
}