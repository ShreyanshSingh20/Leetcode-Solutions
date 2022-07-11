class Solution {
    public int maxResult(int[] arr, int k) {
        
        int n=arr.length;
        Deque<int[]> dq=new ArrayDeque<>();
        dq.addLast(new int[]{0,arr[0]});
        
        int dp[]=new int[n];
        dp[0]=arr[0];
        
        for(int i=1;i<n;i++){
            while(!dq.isEmpty()&&dq.peekLast()[0]<i-k){
                dq.pollLast();
            }
            dp[i]=arr[i]+dq.peekLast()[1];
            while(!dq.isEmpty()&&dp[i]>=dq.peekFirst()[1]){
                dq.pollFirst();
            }
            dq.addFirst(new int[]{i,dp[i]});
        }
        
        return dp[n-1];
    }
}