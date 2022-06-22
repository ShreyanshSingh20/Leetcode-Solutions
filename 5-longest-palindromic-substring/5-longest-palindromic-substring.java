class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        sb.append('#');sb.append('.');
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append('.');
        }
        sb.append('@');
        
        char c[]=sb.toString().toCharArray();
        int n=c.length;
        
        int lps[]=new int[n];
        
        int rightMost=0;int center=0;
        for(int i=1;i<n-1;i++){
            int mirror=center-(i-center);
            if(i<rightMost){
                lps[i]=Math.min(lps[mirror],rightMost-i);
            }
            
            while(i+lps[i]+1<n&&i-lps[i]-1>=0&&
                  c[i+lps[i]+1]==c[i-lps[i]-1]){
                lps[i]++;
            }
            
            if(i+lps[i]>rightMost){
                center=i;
                rightMost=i+lps[i];
            }
        }
        
        int max=1;int ind=-1;
        for(int i=0;i<n;i++){
           if(lps[i]>=max){
               max=lps[i];
               ind=i;
           }
        }
        
        int start=ind-max;
        int end=ind+max+1;
        String res=sb.toString().substring(start,end);
        StringBuilder finsb=new StringBuilder();
        for(int i=0;i<res.length();i++){
            if(res.charAt(i)=='#'||res.charAt(i)=='.'||res.charAt(i)=='@') continue;
            finsb.append(res.charAt(i));
        }
        
        return finsb.toString();
    }
}