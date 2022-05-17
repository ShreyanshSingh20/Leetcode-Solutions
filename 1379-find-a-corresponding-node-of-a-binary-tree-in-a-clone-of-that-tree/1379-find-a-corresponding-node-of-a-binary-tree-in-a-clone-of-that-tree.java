/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inorder(original,cloned,target);
        return res;
    }
    
    TreeNode res=null;
    public void inorder(final TreeNode original,final TreeNode cloned,final TreeNode target){
        if(original==null&&cloned==null) return;
        inorder(original.left,cloned.left,target);
        if(res==null&&original.val==cloned.val&&original==target){
            res=cloned;
            return;
        }
        inorder(original.right,cloned.right,target);
    }
}