class Solution {
    public int firstUniqChar(String s) {
        
        char c[]=s.toCharArray();
        int freq[]=new int[26];
        for(int i=0;i<c.length;i++) freq[c[i]-'a']++;
        
        for(int i=0;i<c.length;i++){
            if(freq[c[i]-'a']==1) return i;
        }
        
        return -1;
    }
}