/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solver(root,p.val,q.val);
    }
    
    public TreeNode solver(TreeNode root,int p,int q){
        
        if(root==null||(root.val==p)||root.val==q) return root;
        
        TreeNode left=solver(root.left,p,q);
        TreeNode right=solver(root.right,p,q);
        
        if(left!=null&&right!=null) return root;
        
        return left==null?right:left;
    }
}