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
    public int minCameraCover(TreeNode root) {
        int ans[]=solver(root);
        return Math.min(ans[1],ans[2]);
    }
    
    public int[] solver(TreeNode root){
        if(root==null) return new int[]{0,0,99999};
        
        int left[]=solver(root.left);
        int right[]=solver(root.right);
        
        int a=left[1]+right[1];
        int b=Math.min(left[2]+Math.min(right[1],right[2]),right[2]+Math.min(left[1],left[2]));
        int c=1+Math.min(left[0],Math.min(left[1],left[2]))+Math.min(right[0],Math.min(right[1],right[2]));
        
        return new int[]{a,b,c};
    }
}