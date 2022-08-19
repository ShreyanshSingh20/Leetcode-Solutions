class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        sb.append('#');sb.append('.');
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append('.');
        }
        sb.append('@');
        
        String str=sb.toString();
        char c[]=str.toCharArray();
        int n=c.length;
        int lps[]=new int[n];
        
        int center=0;int right=0;
        for(int i=1;i<n-1;i++){
            int mirror=center-(i-center);
            if(i<right){
                lps[i]=Math.min(lps[mirror],right-i);
            }
            
            while(i+lps[i]+1<n&&i-lps[i]-1>=0&&
                    c[i+lps[i]+1]==c[i-lps[i]-1]){
                        lps[i]++;
            }
            
            if(i+lps[i]>right){
                center=i;
                right=i+lps[i];
            }
        }
        
        int pos=-1;
        for(int i=n-2;i>=1;i--){
            if(i-lps[i]==1){
                pos=i+lps[i]+1;
                break;
            }
        }
        
        String sub=str.substring(pos);
        StringBuilder temp=new StringBuilder(sub);
        String rev=temp.reverse().toString();
        
        String fin=rev+str;
        
        StringBuilder res=new StringBuilder();
        for(int i=0;i<fin.length();i++){
            if(fin.charAt(i)=='#'||fin.charAt(i)=='.'||fin.charAt(i)=='@') continue;
            res.append(fin.charAt(i));
        }
        
        return res.toString();
    }
}