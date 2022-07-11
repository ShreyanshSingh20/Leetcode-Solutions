class Solution {
    public boolean canChange(String start, String target) {
        
        char c[]=start.toCharArray();
        char t[]=target.toCharArray();
        int n=c.length;
        
        int i=0;int j=0;
        
        while(i<n&&j<n){
            
            while(i<n&&c[i]=='_') i++;
            while(j<n&&t[j]=='_') j++;
            
            if(i==n&&j==n) return true;
            
            if(i==n&&j<n||i<n&&j==n) return false;
            
            if(c[i]!=t[j]) return false;
            
            if(c[i]=='L'){
                if(i<j) return false;
            }
            
            if(c[i]=='R'){
                if(i>j) return false;
            }
            
            i++;
            j++;
            
        }
        
        return true;
    }
}