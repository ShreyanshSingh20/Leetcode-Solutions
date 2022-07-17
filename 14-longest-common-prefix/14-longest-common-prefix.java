class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int minLen=Integer.MAX_VALUE;
        for(String x:strs) minLen=Math.min(minLen,x.length());
        
        if(minLen==0) return "";
        
        StringBuilder sb=new StringBuilder();
        int pt=0;
        while(pt<minLen){
            HashSet<Character> h=new HashSet<>();
            for(String x:strs) h.add(x.charAt(pt));
            if(h.size()>1) break;
            sb.append(strs[0].charAt(pt));
            pt++;
        }
        
        return sb.toString();
    }
}