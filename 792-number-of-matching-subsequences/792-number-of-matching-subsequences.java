class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        HashMap<Character,TreeSet<Integer>> map=new HashMap<>();
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
            map.putIfAbsent(c[i],new TreeSet<Integer>());
            map.get(c[i]).add(i);
        }
        
        int res=0;
        for(int i=0;i<words.length;i++){
            int currInd=-1;boolean present=true;
            for(int j=0;j<words[i].length();j++){
                char ch=words[i].charAt(j);
                if(map.containsKey(ch)){
                    Integer upper=map.get(ch).higher(currInd);
                    if(upper==null){
                        present=false;
                        break;
                    }else{
                        currInd=upper;
                    }
                }else{
                    present=false;
                    break;
                }
            }
            if(present) res++;
        }
        return res;
    }
}