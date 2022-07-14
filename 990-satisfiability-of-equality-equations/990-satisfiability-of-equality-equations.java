class Solution {
    public boolean equationsPossible(String[] arr) {
        
        int n=arr.length;
        
        DisjointSet dsu=new DisjointSet();
        
        for(int i=0;i<n;i++){
            char c[]=arr[i].toCharArray();
            int u=c[0]-97;int v=c[3]-97;
            if(c[1]=='='){
                if(dsu.find(u)!=dsu.find(v)){
                    dsu.union(u,v);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            char c[]=arr[i].toCharArray();
            int u=c[0]-97;int v=c[3]-97;
            if(c[1]=='!'){
                if(dsu.find(u)==dsu.find(v)) return false;
            }else if(c[1]=='='){
                if(dsu.find(u)!=dsu.find(v)){
                    dsu.union(u,v);
                }
            }
        }
        
        return true;
    }
}

class DisjointSet{
    int par[];
    int size[];
    
    public DisjointSet(){
        par=new int[26];
        size=new int[26];
        for(int i=0;i<26;i++) par[i]=i;
        Arrays.fill(size,1);
    }
    
    public int find(int node){
        if(node==par[node]) return node;
        return par[node]=find(par[node]);
    }
    
    public void union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        
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