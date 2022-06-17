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
        return ((dfs(root)==0)?1:0)+cameras;
    }
    
    public int cameras=0;
    
    //if the node is leaf-no need to cover->0
    //if the node is parent of the leaf-need to cover-1
    //if the node's child is the parent of a leaf-already covered-2
    public int dfs(TreeNode root){
        
        if(root==null) return 2;
        
        int left=dfs(root.left);
        int right=dfs(root.right);
        
        if(left==0||right==0){
            cameras++;
            return 1;
        }
        
        if(left==1||right==1) return 2;
        else return 0;
    }
}