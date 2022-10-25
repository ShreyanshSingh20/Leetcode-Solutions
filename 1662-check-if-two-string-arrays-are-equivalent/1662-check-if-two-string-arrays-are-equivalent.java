class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        
        for(String x:word1) a.append(x);
        for(String x:word2) b.append(x);
        
        return a.toString().equals(b.toString());
    }
}