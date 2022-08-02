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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        solver(root,res);
        return res;
    }
    
    public int solver(TreeNode root,List<List<Integer>> a){
        if(root==null) return -1;
        int left=solver(root.left,a);
        int right=solver(root.right,a);
        int level=Math.max(left,right)+1;
        if(a.size()==level){
            a.add(new ArrayList<Integer>());
        }
        a.get(level).add(root.val);
        return level;
    }
}