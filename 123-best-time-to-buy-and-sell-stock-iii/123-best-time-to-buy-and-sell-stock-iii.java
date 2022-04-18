class Solution {
    public int maxProfit(int[] A) {
        int n=A.length;
        if(n==0) return 0;
//         int left[]=new int[n];
//         int right[]=new int[n+1];
//         int smallest=A[0];
//         for(int i=1;i<n;i++){
//             left[i]=Math.max(left[i-1],A[i]-smallest);
//             smallest=Math.min(smallest,A[i]);
//         }
        
//         int largest=A[n-1];
//         for(int i=n-1;i>=0;i--){
//             right[i]=Math.max(right[i+1],largest-A[i]);
//             largest=Math.max(largest,A[i]);
//         }
        
//         int res=0;
//         for(int i=0;i<n;i++){
//             res=Math.max(res,left[i]+right[i+1]);
//         }
//         return res;
        
        int buya=Integer.MAX_VALUE;
        int buyb=Integer.MAX_VALUE;
        int profita=0;int profitb=0;
        for(int x:A){
            buya=Math.min(buya,x);
            profita=Math.max(profita,x-buya);
            
            buyb=Math.min(buyb,x-profita);
            profitb=Math.max(profitb,x-buyb);
        }
        return profitb;
    }
}