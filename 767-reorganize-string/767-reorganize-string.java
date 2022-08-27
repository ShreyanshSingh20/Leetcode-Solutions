class Solution {
    
    public int freq[];
    public String reorganizeString(String s) {
        this.freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        
        StringBuilder sb=new StringBuilder();
        char currChar='#';
        while(sb.length()<s.length()){
            char maxChar=findMaxChar(currChar);
            if(maxChar=='@') return "";
            sb.append(maxChar);
            freq[maxChar-'a']--;
            currChar=maxChar;
        }
        
        return sb.toString();
    }
    
    public char findMaxChar(char currChar){
        
        int maxFreq=0;
        char ans='@';
        
        for(int i=0;i<26;i++){
            if((char)(i+97)==currChar) continue;
            if(freq[i]>maxFreq){
                maxFreq=freq[i];
                ans=(char)(i+97);
            }
        }
        
        return ans;
    }
}