class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        List<Integer> list=new ArrayList<>();
        list.add(0);
        for(int x:cuts) list.add(x);
        list.add(n);
        
        Integer dp[][]=new Integer[list.size()+1][list.size()+1];
        return solver(1,list.size()-2,list,dp);
    }
    
    public int solver(int i,int j,List<Integer> list,Integer dp[][]){
        
        if(i>j) return 0;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        int min=Integer.MAX_VALUE;
        
        for(int ind=i;ind<=j;ind++){
            int cost=(list.get(j+1)-list.get(i-1))+solver(i,ind-1,list,dp)+solver(ind+1,j,list,dp);
            min=Math.min(min,cost);
        }
        
        return dp[i][j]=min;
    }
}