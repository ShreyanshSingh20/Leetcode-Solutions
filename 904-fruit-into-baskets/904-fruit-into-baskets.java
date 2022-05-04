class Solution {
    public int totalFruit(int[] c) {
        //longest subarray with atmost 2 distinct elements
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;int res=1;
        for(int r=0;r<c.length;r++){
            map.putIfAbsent(c[r],0);
            map.put(c[r],map.get(c[r])+1);
            while(map.size()>2){
                int freq=map.get(c[l]);
                if(freq==1) map.remove(c[l]);
                else map.put(c[l],freq-1);
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        
        return res;
    }
}