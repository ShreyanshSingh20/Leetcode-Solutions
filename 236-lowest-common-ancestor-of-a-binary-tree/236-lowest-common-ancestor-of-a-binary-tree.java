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
        return lca(root,p.val,q.val);
    }
    
    public TreeNode lca(TreeNode root,int p,int q){
        if(root==null) return null;
        if(root.val==p||root.val==q){
            return root;
        }
        
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);
        
        if(left!=null&&right!=null) return root;
        
        return (left==null)?right:left;
    }
}