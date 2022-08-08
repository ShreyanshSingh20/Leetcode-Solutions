/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<Pair> list=new ArrayList<>();
        helper(root,0,0,list);
        Collections.sort(list,new Comparator<Pair>(){
            @Override
            public int compare(Pair o1,Pair o2){
                return (o1.level==o2.level)?(o1.vlevel-o2.vlevel):(o1.level-o2.level);
            }
        });
        
        
        List<List<Integer>> res=new ArrayList<>();
		int pt=-1;
		int prev=Integer.MIN_VALUE;
		for(int i=0;i<list.size();i++) {
			int level=list.get(i).level;
			if(level!=prev) {
				prev=level;
				res.add(new ArrayList<>());
				pt++;
				res.get(pt).add(list.get(i).node);
			}else {
				res.get(pt).add(list.get(i).node);
			}
		}
        return res;
        
    }
    
    public void helper(TreeNode root,int level,int vlevel,List<Pair> list){
        if(root==null) return;
        list.add(new Pair(root.val,level,vlevel));
        helper(root.left,level-1,vlevel+1,list);
        helper(root.right,level+1,vlevel+1,list);
    }
    
    class Pair{
        int node;
        int level;
        int vlevel;
        public Pair(int node,int level,int vlevel){
            this.node=node;
            this.level=level;
            this.vlevel=vlevel;
        }
    }
}