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
        return solver(root,target);
    }
    
    double diff=Double.MAX_VALUE;
    public int solver(TreeNode root,double target){
        TreeNode res=null;
        while(root!=null){
            double val=root.val;
            double currDiff=Math.abs(target-val);
            if(currDiff<diff){
                diff=currDiff;
                res=root;
            }
            
            if(val==target) return root.val;
            
            if(target<val) root=root.left;
            else if(target>val) root=root.right;
        }
        
        return res.val;
        
    }
}