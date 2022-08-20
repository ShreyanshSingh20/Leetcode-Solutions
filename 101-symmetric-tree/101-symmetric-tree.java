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
    public boolean isSymmetric(TreeNode root) {
        return (root==null||solver(root.left,root.right));
    }
    
    public boolean solver(TreeNode a,TreeNode b){
        if(a==null||b==null) return a==b;
        
        if(a.val!=b.val) return false;
        
        return solver(a.left,b.right)&&solver(a.right,b.left);
    }
}