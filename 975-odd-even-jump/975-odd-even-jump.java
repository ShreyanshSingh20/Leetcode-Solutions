class Solution {
    public int oddEvenJumps(int[] arr) {
        
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][2];
        dp[n-1][0]=dp[n-1][1]=true;
        
        TreeMap<Integer,TreeSet<Integer>> tset=new TreeMap<>();
        tset.putIfAbsent(arr[n-1],new TreeSet<Integer>());
        tset.get(arr[n-1]).add(n-1);
        
        int res=1;
        
        for(int i=n-2;i>=0;i--){
            
            //for odd step updation
            Integer ceil=tset.ceilingKey(arr[i]);
            if(ceil!=null){
                int smallestIdx=tset.get(ceil).first();
                dp[i][0]=dp[smallestIdx][1];
            }
            
            //for even step updation
            Integer floor=tset.floorKey(arr[i]);
            if(floor!=null){
                int smallestIdx=tset.get(floor).first();
                dp[i][1]=dp[smallestIdx][0];
            }
            
            tset.putIfAbsent(arr[i],new TreeSet<Integer>());
            tset.get(arr[i]).add(i);
            
            res+=(dp[i][0]==true)?1:0;
        }
        
        return res;
    }
}