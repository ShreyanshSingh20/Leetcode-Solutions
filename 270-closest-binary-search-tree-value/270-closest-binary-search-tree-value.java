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
    public int closestValue(TreeNode root, double target) {
        solver(root,target);
        return res.val;
    }
    
    double diff=Double.MAX_VALUE;
    TreeNode res=null;
    public void solver(TreeNode root,double target){
        if(root==null) return;
        solver(root.left,target);
        double val=root.val;
        double currDiff=Math.abs(target-val);
        if(currDiff<diff){
            diff=currDiff;
            res=root;
        }
        solver(root.right,target);
    }
}