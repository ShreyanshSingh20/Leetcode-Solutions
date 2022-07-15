class Solution {

    int prefSum[];
    int n;
    int sum;
    public Solution(int[] w) {
        this.n=w.length;
        prefSum=new int[n];
        prefSum[0]=w[0];
        this.sum=w[0];
        for(int i=1;i<n;i++) {
            prefSum[i]=prefSum[i-1]+w[i];
            this.sum+=w[i];
        }
        
    }
    
    public int pickIndex() {
        double random=this.sum*(Math.random());
        int l=0;int r=n-1;
        while(l<r){
            int mid=(l+r)/2;
            if(random>prefSum[mid]) l=mid+1;
            else r=mid;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */