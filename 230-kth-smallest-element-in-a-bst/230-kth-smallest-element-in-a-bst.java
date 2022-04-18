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
    public int result=-1;
    public int cnt=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }
    
    public void inorder(TreeNode root,int k){
        if(root==null) return;
        inorder(root.left,k);
        cnt++;
        if(cnt==k&&result==-1) {result=root.val;}
        inorder(root.right,k);
        
    }
}