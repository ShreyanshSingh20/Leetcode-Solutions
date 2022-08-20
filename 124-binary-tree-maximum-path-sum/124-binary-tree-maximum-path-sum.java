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
    public int maxPathSum(TreeNode root) {
        solver(root);
        return res;
    }
    
    public int res=Integer.MIN_VALUE;
    
    public int solver(TreeNode root){
        
        if(root==null) return Integer.MIN_VALUE/4;
        
        int left=solver(root.left);
        int right=solver(root.right);
        
        res=Math.max(res,left);
        res=Math.max(res,right);
        res=Math.max(res,left+root.val);
        res=Math.max(res,right+root.val);
        res=Math.max(res,left+root.val+right);
        res=Math.max(res,root.val);
        
        return Math.max(root.val,Math.max(root.val+left,root.val+right));
    }
}