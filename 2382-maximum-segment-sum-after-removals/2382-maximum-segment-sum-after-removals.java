class Solution {
    public long[] maximumSegmentSum(int[] arr, int[] query) {
        
        int n=arr.length;
        DSU dsu=new DSU(n);
        
        long res[]=new long[n];
        int pt=n-2;
        
        long max=Long.MIN_VALUE;
        
        for(int i=query.length-1;i>0;i--){
            int ind=query[i];
            int elem=arr[ind];
            if(dsu.sum[ind]==Long.MIN_VALUE){
                dsu.sum[ind]=elem;
                if(ind-1>=0&&dsu.sum[ind-1]!=Long.MIN_VALUE){
                    int par=dsu.find(ind-1);
                    dsu.union(ind,par);
                }
                if(ind+1<arr.length&&dsu.sum[ind+1]!=Long.MIN_VALUE){
                    int par=dsu.find(ind+1);
                    dsu.union(ind,par);
                }
                
                int newPar=dsu.find(ind);
                long newSum=dsu.sum[newPar];
                max=Math.max(max,newSum);
                res[pt]=max;
                pt--;
            }
        }
        
        return res;
    }
}

class DSU{
    int par[];
    long sum[];
    
    public DSU(int n){
        par=new int[n];
        for(int i=0;i<n;i++) par[i]=i;
        sum=new long[n];
        Arrays.fill(sum,Long.MIN_VALUE);
    }
    
    public int find(int node){
        if(node==par[node]) return node;
        return par[node]=find(par[node]);
    }
    
    public void union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        
        if(pu==pv) return;
        
        if(sum[pu]>=sum[pv]){
            sum[pu]+=sum[pv];
            par[pv]=pu;
        }else{
            sum[pv]+=sum[pu];
            par[pu]=pv;
        }
    }
}