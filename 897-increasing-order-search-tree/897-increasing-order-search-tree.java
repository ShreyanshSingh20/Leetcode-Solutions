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
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return node;
    }
    
    public TreeNode node=null;
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.right);
        root.right=node;
        node=root;
        helper(root.left);
        root.left=null;
    }
}