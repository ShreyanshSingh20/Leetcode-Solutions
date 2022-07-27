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
        
        while(root!=null){
            TreeNode left=root.left;
            if(left==null){
                root=root.right;
            }else{
                TreeNode rightMostNode=getRightMostNode(left,root);
                if(rightMostNode.right==null){
                    rightMostNode.right=root.right;
                    root.right=root.left;
                    root.left=null;
                }
                root=root.right;
            }
        }
    }
    
    public TreeNode getRightMostNode(TreeNode left,TreeNode root){
        while(left!=null&&left.right!=null&&left.right!=root) left=left.right;
        return left;
    }
}