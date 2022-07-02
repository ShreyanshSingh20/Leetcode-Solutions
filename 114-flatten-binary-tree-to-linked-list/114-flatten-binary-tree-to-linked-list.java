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
    public void flatten(TreeNode root) {
        solver(root);
    }
    
    public TreeNode solver(TreeNode root){
        if(root==null) return null;
        TreeNode leftNode=solver(root.left);
        root.left=null;
        TreeNode rightNode=solver(root.right);
        root.right=leftNode;
        while(leftNode!=null&&leftNode.right!=null) leftNode=leftNode.right;
        if(leftNode!=null) leftNode.right=rightNode;
        else root.right=rightNode;
        return root;
    }
}