/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//turn the binary tree into a graph and do the necessary thing
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        inorder(root,map);
        
        int src=target.val;
        HashSet<Integer> vis=new HashSet<>();
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{src,0});
        vis.add(src);
        
        List<Integer> res=new ArrayList<>();
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int node=curr[0];int dist=curr[1];
                
                if(dist==k) res.add(node);
                
                if(!map.containsKey(node)) continue;
                
                Iterator<Integer> e=map.get(node).iterator();
                while(e.hasNext()){
                    int next=(int)e.next();
                    if(!vis.contains(next)){
                        vis.add(next);
                        q.add(new int[]{next,dist+1});
                    }
                }
            }
        }
        
        return res;
    }
    
    public void inorder(TreeNode root,HashMap<Integer,HashSet<Integer>> map){
        if(root==null) return;
        int u=root.val;
        inorder(root.left,map);
        if(root.left!=null){
            int v=root.left.val;
            addEdge(map,u,v);
        }
        
        if(root.right!=null){
            int v=root.right.val;
            addEdge(map,u,v);
        }
        inorder(root.right,map);
    }
    
    public void addEdge(HashMap<Integer,HashSet<Integer>> map,int u,int v){
        map.putIfAbsent(u,new HashSet<Integer>());
        map.get(u).add(v);
        
        map.putIfAbsent(v,new HashSet<Integer>());
        map.get(v).add(u);
    }
}