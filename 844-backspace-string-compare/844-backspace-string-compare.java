class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder a=new StringBuilder();
        StringBuilder b=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'&&a.length()>0) a.deleteCharAt(a.length()-1);
            else if(s.charAt(i)!='#') a.append(s.charAt(i));
        }
        
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'&&b.length()>0) b.deleteCharAt(b.length()-1);
            else if(t.charAt(i)!='#') b.append(t.charAt(i));
        }
        
        String sa=a.toString();
        String sb=b.toString();
        
        return sa.contentEquals(sb);
    }
}