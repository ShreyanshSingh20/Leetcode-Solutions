class Solution {
    public long sumScores(String s) {
        char c[]=s.toCharArray();
        int n=c.length;
        int z[]=new int[n];
        for(int i=1,l=0,r=0;i<n;i++){
            if(i<=r) z[i]=Math.min(z[i-l],r-i+1);
            while(i+z[i]<n&&c[z[i]]==c[i+z[i]])
                ++z[i];
            if(i+z[i]-1>r){
                l=i;r=i+z[i]-1;
            }
        }
        
        long sum=0;
        for(int x:z) sum+=x;
        sum+=n;
        return sum;
    }
}