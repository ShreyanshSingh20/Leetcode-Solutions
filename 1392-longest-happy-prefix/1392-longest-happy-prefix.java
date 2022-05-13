class Solution {
    public String longestPrefix(String s) {
        char c[]=s.toCharArray();
        int n=c.length;
        int z[]=new int[n];
        for(int i=1,l=0,r=0;i<n;i++){
            if(i<=r) z[i]=Math.min(z[i-l],r-i+1);
            while(i+z[i]<n&&c[z[i]]==c[i+z[i]]) ++z[i];
            if(i+z[i]-1>r){
                l=i;r=i+z[i]-1;
            }
        }
        
        int ind=-1;int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(z[i]>max&&i+z[i]-1==n-1){
                max=z[i];
                ind=i;
            }
        }
        
        if(max==Integer.MIN_VALUE) return "";
        return s.substring(ind,n);
    }
}