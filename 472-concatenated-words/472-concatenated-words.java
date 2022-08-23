class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int ind=i;int len=words[i].length();
            list.add(new Pair(ind,len));
        }
        
        Collections.sort(list,new Comparator<Pair>(){
            
            @Override
            public int compare(Pair o1,Pair o2){
                return o1.len-o2.len;
            }
        });
        
        int pt=0;
        HashSet<String> set=new HashSet<>();
        set.add(words[list.get(pt).ind]);
        
        while(pt+1<list.size()&&list.get(pt).len==list.get(pt+1).len){
            set.add(words[list.get(pt+1).ind]);
            pt++;
        }
        
        pt++;
        
        List<String> res=new ArrayList<String>();
        
        while(pt<list.size()){
            int len=list.get(pt).len;
            Boolean dp[]=new Boolean[len+1];
            if(check(words[list.get(pt).ind],set,0,dp)){
                res.add(words[list.get(pt).ind]);
            }
            set.add(words[list.get(pt).ind]);
            pt++;
        }
        
        return res;
    }
    
    public boolean check(String str,HashSet<String> set,int prev,Boolean dp[]){
        
        if(prev==str.length()) return true;
        
        if(dp[prev]!=null) return dp[prev];
        
        boolean res=false;
        for(int i=prev;i<str.length();i++){
            String sub=str.substring(prev,i+1);
            if(set.contains(sub)){
                res=check(str,set,i+1,dp);
                if(res==true) return dp[prev]=true;
            }
        }
        
        return dp[prev]=res;
    }
}

class Pair{
    int ind;
    int len;
    
    public Pair(int ind,int len){
        this.ind=ind;
        this.len=len;
    }
}