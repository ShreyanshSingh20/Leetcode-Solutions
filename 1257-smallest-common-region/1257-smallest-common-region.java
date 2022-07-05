class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        HashMap<String,Integer> map=new HashMap<>();
        HashMap<Integer,String> revMap=new HashMap<>();
        HashMap<Integer,Integer> parent=new HashMap<>();
        
        int node=-1;
        for(int i=0;i<regions.size();i++){
            int par=-1;
            for(int j=0;j<regions.get(i).size();j++){
                if(!map.containsKey(regions.get(i).get(j))){
                    node++;
                    map.put(regions.get(i).get(j),node);
                    revMap.put(node,regions.get(i).get(j));
                    if(j==0) {par=node; continue;}
                    parent.put(node,par);
                }else{
                    if(j==0) par=map.get(regions.get(i).get(j));
                }
              
            }
        }
        
        Deque<Integer> dq1=new ArrayDeque<>();
        Deque<Integer> dq2=new ArrayDeque<>();
        
        int p=map.get(region1);int q=map.get(region2);
        
        //for p
        dq1.addLast(p);
        while(parent.containsKey(p)){
            dq1.addLast(parent.get(p));
            p=parent.get(p);
        }
        
        //for q
        dq2.addLast(q);
        while(parent.containsKey(q)){
            dq2.addLast(parent.get(q));
            q=parent.get(q);
        }
        
        int res=-1;
        while((dq1.peekLast()==dq2.peekLast())&&!dq1.isEmpty()&&!dq2.isEmpty()){
            res=dq1.peekLast();
            dq1.pollLast();
            dq2.pollLast();
        }
        
        return revMap.get(res);
    }
}

