class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> list=new ArrayList<>();
        
        int n=words.length;
        
        int i=0;
        
        while(i<n){
            int fittingWordsLen=words[i].length();
            int j=i+1;
            int spaces=1;
            while(j<n&&fittingWordsLen+words[j].length()+spaces<=maxWidth){
                fittingWordsLen+=words[j].length();
                j++;
                spaces++;
            }
            
            int numOfWords=j-i;
            int vacantSpaces=maxWidth-fittingWordsLen;
            
            int cand=numOfWords-1;
            int atleast=cand==0?0:vacantSpaces/cand;
            
            int extra=cand==0?0:vacantSpaces%cand;
            
            if(j==n){
                atleast=1;
                extra=0;
            }
            
            StringBuilder sb=new StringBuilder();
            for(int k=i;k<j;k++){
                sb.append(words[k]);
                if(k==j-1) break;
                for(int l=0;l<atleast;l++){
                    sb.append(' ');
                }
                if(extra>0){
                    sb.append(' ');
                    extra--;
                }
            }
            
            while(sb.length()<maxWidth) sb.append(' ');
            
            i=j;
            list.add(sb.toString());
        }
        
        return list;
    }
}