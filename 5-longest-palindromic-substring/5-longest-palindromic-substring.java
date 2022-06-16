class Solution {
    public String longestPalindrome(String s) {
        StringBuilder temp=new StringBuilder();
        char ct[]=s.toCharArray();
        int n=ct.length;
        if(n==0) return "";
        for(int i=0;i<n;i++){
            temp.append(ct[i]);
            temp.append('*');
        }
        int start=-1;int end=-1;int maxLen=Integer.MIN_VALUE;
        String newstr=temp.toString();
        char c[]=newstr.toCharArray();
        n=c.length;
        for(int i=0;i<n;i++){
            int l=i;int r=i;
            while(l>=0&&r<n&&c[l]==c[r]){
                l--;r++;
            }
            l++;r--;
            int currLen=r-l+1;
            if(currLen>maxLen){
                start=l;end=r;
                maxLen=currLen;
            }
        }
        
        String res=newstr.substring(start,end+1);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<res.length();i++){
            if(res.charAt(i)!='*') ans.append(res.charAt(i));
        }
        return ans.toString();
    }
}