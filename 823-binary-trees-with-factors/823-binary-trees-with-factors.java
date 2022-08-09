class Solution {
    
    public long mod=1_000_000_007;
    
    public int numFactoredBinaryTrees(int[] arr) {
        
        Arrays.sort(arr);
        //we know that if root node is the multiplication of left and right then 
        //left and right must be smaller than the root node
        
        int n=arr.length;
        long dp[]=new long[n];
        Arrays.fill(dp,1);
        //dp[i]->represents the number of binary trees with arr[i] as the root node;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    int right=arr[i]/arr[j];
                    if(map.containsKey(right)){
                        int k=map.get(right);
                        dp[i]=add(dp[i],mul(dp[j],dp[k]));
                    }
                }
            }
        }
        
        long res=0;
        for(long x:dp) res=add(res,x);
        return (int)res;
    }
    
    public long add(long x,long y){
        x+=y;
        if(x>=mod) return x%mod;
        return x;
    }
    
    public long mul(long x,long y){
        return (x*y)%mod;
    }
}