class Solution {
    public int[] amountPainted(int[][] paint) {
        int n=paint.length;
        int res[]=new int[n];
        
        int last[]=new int[50005];
        Arrays.fill(last,-1);
        
        FenwickTree ft=new FenwickTree(50005);
        DisjointSet dsu=new DisjointSet(50005);
        for(int i=0;i<n;i++){
            int start=paint[i][0]+1;int end=paint[i][1];
            int sum=ft.getSum(start,end);
            res[i]=(end-start+1)-sum;
            //handle for the first one
            int parStart=dsu.find(start);
            if(last[parStart]!=-1){
                start=last[parStart]+1;
            }else{
                ft.update(start,1);
                last[parStart]=Math.max(end,last[parStart]);
                start++;
            }
            
            while(start<=end){
                int par=dsu.find(start);
                if(last[par]!=-1){
                    start=last[par]+1;
                }else{
                    ft.update(start,1);
                    dsu.union(start,start-1);
                    int newPar=dsu.find(start);
                    last[newPar]=Math.max(end,last[newPar]);
                    start++;
                }
            }
        }
        
        return res;
    }
}

class FenwickTree{
    int arr[];
    
    public FenwickTree(int n){
        arr=new int[n];
    }
    
    public void update(int i,int add){
        while(i<arr.length){
            arr[i]+=add;
            i=i+(i&(-i));
        }
    }
    
    public int sum(int i){
        int res=0;
        while(i>0){
            res+=arr[i];
            i=i-(i&(-i));
        }
        return res;
    }
    
    public int getSum(int l,int r){
        return sum(r)-sum(l-1);
    }
}

class DisjointSet{
    int par[];
    int size[];
    
    public DisjointSet(int n){
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++) par[i]=i;
        Arrays.fill(size,1);
    }
    
    public int find(int node){
        if(node==par[node]) return node;
        return par[node]=find(par[node]);
    }
    
    public void union(int u,int v){
        int pu=find(u);int pv=find(v);
        if(pu==pv) return;
        
        if(size[pu]<=size[pv]){
            size[pv]+=size[pu];
            par[pu]=pv;
        }else{
            size[pu]+=size[pv];
            par[pv]=pu;
        }
    }
}