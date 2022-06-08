class Solution {
    public int removePalindromeSub(String s) {
        char c[]=s.toCharArray();
        if(isPalin(c)) return 1;
        return 2;
    }
    
    public boolean isPalin(char c[]){
        int l=0;int r=c.length-1;
        while(l<=r){
            if(c[l]!=c[r]) return false;
            l++;r--;
        }
        return true;
    }
}