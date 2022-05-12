class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
        int n=arr.length;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i],0);
            map.put(arr[i],map.get(arr[i])+1);
        }
        
        List<List<Integer>> res=new ArrayList<>();
        solver(n,new ArrayList<Integer>(),res,map);
        return res;
        
    }
    
    public void solver(int n,List<Integer> sub,List<List<Integer>> res,
                       HashMap<Integer,Integer> map){
        
        if(sub.size()==n){
            res.add(new ArrayList<>(sub));
            return;
        }
        
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            if(val==0) continue;
            
            sub.add(key);
            map.put(key,val-1);
            
            solver(n,sub,res,map);
            
            if(sub.size()>0) sub.remove(sub.size()-1);
            map.put(key,val);
        }
    }
}