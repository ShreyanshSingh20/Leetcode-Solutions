class Solution {
    public int numDupDigitsAtMostN(int n) {
        String str=n+"";
        int len=str.length();
        int uniqueDigits=0;
        for(int i=1;i<len;i++){
            int dp[][]=new int[i+1][(1<<10)-1];
            for(int x[]:dp) Arrays.fill(x,-1);
            int sub=solver(0,i,0,dp);
            // System.out.println(i+" "+sub);
            uniqueDigits+=sub;
        }
        
        int dp2[][][]=new int[len+1][(1<<10)-1][2];
        for(int x[][]:dp2){
            for(int y[]:x){
                Arrays.fill(y,-1);
            }
        }
        int curr=solver2(str,0,len,0,1,dp2);
        uniqueDigits+=curr;
        // System.out.println(len+" "+curr);
        return n-uniqueDigits;
        
    }
    
    public int solver(int i,int len,int mask,int dp[][]){
        
        if(i==len) return 1;
        
        if(dp[i][mask]!=-1) return dp[i][mask];
        
        int res=0;
        for(int j=0;j<=9;j++){
            if(i==0&&j==0) continue;
            if((mask&(1<<j))==0){
                res+=solver(i+1,len,mask|(1<<j),dp);
            }
        }
        
        return dp[i][mask]=res;
    }
    
    
    public int solver2(String str,int i,int len,int mask,int bound,int dp[][][]){
        
        if(i==len) return 1;
        
        if(dp[i][mask][bound]!=-1) return dp[i][mask][bound];
        int res=0;
        int upperBound=(bound==1)?(int)(str.charAt(i)-'0'):9;
        for(int j=0;j<=upperBound;j++){
            if(i==0&&j==0) continue;
            if((mask&(1<<j))==0){
                int nextBounded=bound&(j==upperBound?1:0);
                res+=solver2(str,i+1,len,mask|(1<<j),nextBounded,dp);
            }
        }
        
        return dp[i][mask][bound]=res;
    }
    
}