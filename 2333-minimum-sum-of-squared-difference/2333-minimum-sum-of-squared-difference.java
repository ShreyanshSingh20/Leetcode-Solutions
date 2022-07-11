class Solution {
    public long minSumSquareDiff(int[] a, int[] b, int k1, int k2) {
        
        int n=a.length;
        int ops=k1+k2;
        
        int bucket[]=new int[100005];
        for(int i=0;i<n;i++){
            bucket[Math.abs(a[i]-b[i])]++;
        }
        
        for(int i=bucket.length-1;i>0;i--){
            int freq=Math.min(ops,bucket[i]);
            ops-=freq;
            bucket[i-1]+=freq;
            bucket[i]-=freq;
            if(ops==0) break;
        }
        
        long res=0;
        for(int i=0;i<bucket.length;i++){
            res=res+(long)(bucket[i])*(long)i*(long)i;
        }
        
        return res;
    }
}