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
    public boolean findTarget(TreeNode root, int B) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        int l=0;int r=list.size()-1;
        while(l<r){
            if(list.get(l)+list.get(r)==B) return true;
            if(list.get(l)+list.get(r)<B) l++;
            else r--;
        }
        
        return false;
    }
    
    public void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}