class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        
        for(String x:wordDict) set.add(x);
        
        solver(s,set,0,res,temp);
        
        return res;
    }
    
    public void solver(String s,HashSet<String> set,int prev,List<String> res,List<String> temp){
        
        if(prev==s.length()){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<temp.size();i++){
                sb.append(temp.get(i));
                if(i!=temp.size()-1) sb.append(" ");
            }
            res.add(sb.toString());
            return;
        }
        
        for(int i=prev;i<s.length();i++){
            String sub=s.substring(prev,i+1);
            if(set.contains(sub)){
                temp.add(sub);
                solver(s,set,i+1,res,temp);
                if(temp.size()>0) temp.remove(temp.size()-1);
            }
        }
    }
}