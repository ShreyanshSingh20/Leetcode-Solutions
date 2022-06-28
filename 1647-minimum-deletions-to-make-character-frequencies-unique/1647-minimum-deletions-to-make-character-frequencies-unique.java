class Solution {
    public int minDeletions(String s) {
        char c[]=s.toCharArray();
        int n=c.length;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(c[i],map.getOrDefault(c[i],0)+1);
        
        HashMap<Integer,Stack<Character>> freq=new HashMap<>();
        
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=1;i<=100005;i++) set.add(i);
        List<Integer> toRemove=new ArrayList<>();
        
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            char key=e.getKey();
            int val=e.getValue();
            freq.putIfAbsent(val,new Stack<Character>());
            freq.get(val).push(key);
            set.remove(val);
            toRemove.add(val);
        }
        
        int res=0;
        for(int i=0;i<toRemove.size();i++){
            int val=toRemove.get(i);
            while(freq.get(val).size()>1){
                int currVal=val;
                freq.get(val).pop();
                Integer highest=set.floor(currVal);
                if(highest==null) res+=currVal;
                else{
                    res+=currVal-highest;
                    set.remove(highest);
                }
            }
        }
        
        return res;
        
        
    }
}