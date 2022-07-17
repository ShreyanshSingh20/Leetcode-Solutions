class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char c[]=word.toCharArray();
        char abv[]=abbr.toCharArray();
        Boolean dp[][][]=new Boolean[21][11][2];
        return match(0,c,0,abv,0,dp);
    }
    
    public boolean match(int i,char c[],int j,char abv[],int prevWasDigit,Boolean dp[][][]){
        
        if(i==c.length&&j==abv.length) return true;
        if(i<c.length&&j>=abv.length) return false;
        if(i>=c.length&&j<abv.length) return false;
        if(i>c.length&&j>=abv.length) return false;
        
        if(dp[i][j][prevWasDigit]!=null) return dp[i][j][prevWasDigit];
        
        // System.out.println(i+" "+j);
        
        boolean res=false;
        if(abv[j]>=97&&abv[j]<=122){
            if(c[i]==abv[j]){
                res=match(i+1,c,j+1,abv,0,dp);
                if(res==true) return dp[i][j][prevWasDigit]=true;
            }
        }else{
            if(prevWasDigit==0){
                int k=j;
                if(abv[k]=='0') return false;
                int num=0;
                while(k<abv.length&&abv[k]>=48&&abv[k]<=57){
                    int dig=abv[k]-'0';
                    num=num*10+dig;
                    res=match(i+num,c,k+1,abv,1,dp);
                    if(res==true) return dp[i][j][prevWasDigit]=true;
                    k++;
                }
            }
        }
        
        return dp[i][j][prevWasDigit]=res;
    }
}