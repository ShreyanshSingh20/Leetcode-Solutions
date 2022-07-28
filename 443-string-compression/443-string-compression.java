class Solution {
    public int compress(char[] c) {
        
        int n=c.length;
        char currChar=c[0];
        int currCount=1;
        int pointer=0;
        
        for(int i=1;i<n;i++){
            if(c[i]==c[i-1]) currCount++;
            else{
                if(currCount==1){
                    char prev=currChar;
                    currChar=c[i];
                    c[pointer]=prev;
                    pointer++;
                    currCount=1;
                }else{
                    char prev=currChar;
                    currChar=c[i];
                    c[pointer]=prev;
                    pointer++;
                    String freq=currCount+"";
                    for(int j=0;j<freq.length();j++){
                        c[pointer]=freq.charAt(j);
                        pointer++;
                    }
                    currCount=1;
                }
            }
        }
        
        if(currCount>0){
            char prev=currChar;
            c[pointer]=prev;
            pointer++;
            if(currCount!=1){
                String freq=currCount+"";
                for(int j=0;j<freq.length();j++){
                    c[pointer]=freq.charAt(j);
                    pointer++;
                }
            }
        }
        
        return pointer;
    }
}