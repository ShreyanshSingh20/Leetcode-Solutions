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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        List<List<TreeNode>> list=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        int pt=-1;
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            if(size>0) {pt++; list.add(new ArrayList<TreeNode>());}
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                TreeNode newNode=new TreeNode(curr.val);
                list.get(pt).add(newNode);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        
        for(int i=1;i<list.size();i++){
            if(list.get(i).size()>1) list.get(i).get(0).left=list.get(i).get(1);
            list.get(i).get(0).right=list.get(i-1).get(0);
        }
        
        return list.get(list.size()-1).get(0);
    }
}