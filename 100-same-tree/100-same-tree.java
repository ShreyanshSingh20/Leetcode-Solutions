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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null||p!=null&&q==null) return false;
        if(p==null&&q==null) return true;
        return identical(p,q);
    }
    
    public boolean identical(TreeNode p, TreeNode q){
        
        if(p.val!=q.val) return false;
        
        if((p.left==null&&q.left!=null)||(p.left!=null&&q.left==null)) return false;
        if((p.right!=null&&q.right==null)||(p.right==null&&q.right!=null)) return false;
        
        boolean left=true;boolean right=true;
        if(p.left!=null&&q.left!=null)
            left=identical(p.left,q.left);
        if(p.right!=null&&q.right!=null)
            right=identical(p.right,q.right);
        
        return (left&&right);
    }
}