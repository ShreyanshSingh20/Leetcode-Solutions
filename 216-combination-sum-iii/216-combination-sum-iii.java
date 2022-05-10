class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> finList=new ArrayList<>();
        List<Integer> subList=new ArrayList<>();
        helper(1,k,n,subList,finList);
        return finList;
    }
    
    public void helper(int i,int k,int n,List<Integer> subList,List<List<Integer>> finList){
        
        if(k==0){
            if(n==0){
                finList.add(new ArrayList<>(subList));
            }
            return;
        }
        
        if(i<=Math.min(n,9)){
            subList.add(i);
            helper(i+1,k-1,n-i,subList,finList);
            if(subList.size()>0) subList.remove(subList.size()-1);
            helper(i+1,k,n,subList,finList);
        }
    }
}