class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        int n=words.size();
        
        //storing the initial abbreviations
        String ans[]=new String[n];
        for(int i=0;i<n;i++){
            ans[i]=abbrev(words.get(i),0);
        }
        
        int prefix[]=new int[n];
        
        for(int i=0;i<n;i++){
            while(true){
                Set<Integer> duplicates=new HashSet<>();
                for(int j=i+1;j<n;j++){
                    if(ans[j].equals(ans[i])) duplicates.add(j);
                }
                if(duplicates.isEmpty()) break;
                duplicates.add(i);
                for(int x:duplicates){
                    ans[x]=abbrev(words.get(x),++prefix[x]);
                }
            }
        }
        
        return Arrays.asList(ans);
    }
    
    public String abbrev(String word,int i){
        int n=word.length();
        if(n-i<=3) return word;
        return word.substring(0,i+1)+(n-i-2)+word.charAt(n-1);
    }
}