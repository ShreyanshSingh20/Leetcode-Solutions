class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        int n=words.length;
        int m=pattern.length();
        
        List<String> res=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            HashMap<Character,Character> a=new HashMap<>();
            HashMap<Character,Character> b=new HashMap<>();
            boolean candidate=true;
            for(int j=0;j<m;j++){
                char u=pattern.charAt(j);
                char v=words[i].charAt(j);
                if(a.containsKey(u)&&a.get(u)!=v) candidate=false;
                else if(b.containsKey(v)&&b.get(v)!=u) candidate=false;
                else if(!a.containsKey(u)&&!b.containsKey(v)){
                    a.put(u,v);
                    b.put(v,u);
                }
            }
            
            if(candidate) res.add(words[i]);
        }
        
        return res;
    }
}

// class DisjointSet{
//     int parent[];
//     int size[];
    
//     public DisjointSet(){
//         parent=new int[26];
//         size=new int[26];
//         Arrays.fill(size,1);
//         for(int i=0;i<26;i++) parent[i]=i;
//     }
    
//     public int find(int node){
//         if(parent[node]==node) return node;
//         return parent[node]=find(parent[node]);
//     }
    
//     public void union(int a,int b){
//         int pa=find(a);
//         int pb=find(b);
        
//         if(pa==pb) return;
        
//         if(size[pa]<=size[pb]){
//             size[pb]+=size[pa];
//             parent[pa]=pb;
//         }else{
//             size[pa]+=size[pb];
//             parent[pb]=pa;
//         }
//     }
// }