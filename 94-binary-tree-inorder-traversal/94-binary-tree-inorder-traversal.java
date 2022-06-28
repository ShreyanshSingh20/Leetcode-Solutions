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
    
    public TreeNode getRightMostNode(TreeNode left,TreeNode curr){
        while(left.right!=null&&left.right!=curr) left=left.right;
        return left;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr=root;
        List<Integer> list=new ArrayList<>();
        while(curr!=null){
            TreeNode left=curr.left;
            
            if(left==null){
                list.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode rightMostNode=getRightMostNode(left,curr);
                
                if(rightMostNode.right==null){
                    //means we have to create a thread
                    rightMostNode.right=curr;
                    curr=curr.left;
                }else{
                    //means we had an already created threaded so we need to destroy it now
                    rightMostNode.right=null;
                    list.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        
        return list;
    }
}