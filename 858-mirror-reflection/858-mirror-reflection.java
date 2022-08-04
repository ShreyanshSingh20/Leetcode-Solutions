class Solution {
    public int mirrorReflection(int p, int q) {
        int m=1;int n=1;
        while(m*p!=n*q){
            n++;
            m=(n*q)/p;
        }
        
        if(n%2!=0){
            if(m%2==0) return 0;
            else return 1;
        }else{
            return 2;
        }
    }
}