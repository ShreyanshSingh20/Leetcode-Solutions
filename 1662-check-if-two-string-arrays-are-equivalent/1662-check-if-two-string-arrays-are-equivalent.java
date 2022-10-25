class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        int pt1 = 0;int pt2 = 0;int i = 0;int j = 0;
        while(i < word1.length && j < word2.length){
            if(pt1==word1[i].length()) {pt1=0; i++;}
            if(pt2==word2[j].length()) {pt2=0; j++;}
            if(i == word1.length || j == word2.length) break;
            if(word1[i].charAt(pt1)!=word2[j].charAt(pt2)) return false;
            pt1++;pt2++;
        }
        
        if(i == word1.length && j == word2.length && pt1 == 0 && pt2 == 0) return true;
        
        return false;
    }
}