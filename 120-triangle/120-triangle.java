class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int r=list.size();
        for(int i=1;i<r;i++){
            for(int j=0;j<list.get(i).size();j++){
                int curr=list.get(i).get(j);
                int min=Integer.MAX_VALUE;
                if(j>=0&&j<list.get(i-1).size()){
                    min=Math.min(min,curr+list.get(i-1).get(j));
                }
                if(j-1>=0&&j-1<list.get(i-1).size()){
                     min=Math.min(min,curr+list.get(i-1).get(j-1));
                }
                list.get(i).set(j,min);
            }
        }
        
        int res=Integer.MAX_VALUE;
        for(int i=0;i<list.get(r-1).size();i++){
            res=Math.min(res,list.get(r-1).get(i));
        }
        return res;
    }
}