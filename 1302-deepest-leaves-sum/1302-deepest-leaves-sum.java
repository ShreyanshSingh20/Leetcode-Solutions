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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int prevSum=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            prevSum=0;
            while(size>0){
                TreeNode curr=queue.poll();
                prevSum+=curr.val;
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
                size--;
            }
        }
        
        return prevSum;
    }
}