class Solution {
    public double myPow(double x, int n) {
        
        long N=n;
        if(N<0){
            N=-N;
            x=1/x;
        }
        
        return solver(x,N);
    }
    
    public double solver(double x,long n){
        if(n==0) return 1.0;
        double res=solver(x,n/2);
        if(n%2==0){
            return res*res;
        }else{
            return res*res*x;
        }
    }
}