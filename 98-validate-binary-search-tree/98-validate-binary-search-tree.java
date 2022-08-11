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
    public boolean isValidBST(TreeNode root) {
        solver(root);
        return res;
    }
    
    public boolean res=true;
    
    public Pair solver(TreeNode root){
        
        if(root==null){
            return new Pair(Long.MAX_VALUE,Long.MIN_VALUE);
        }
        
        Pair a=solver(root.left);
        Pair b=solver(root.right);
        long maxFromLeft=a.max;
        long minFromRight=b.min;
        if(root.val<=maxFromLeft||root.val>=minFromRight) res=false;
        
        long newMin=Math.min(Math.min(a.min,b.min),root.val);
        long newMax=Math.max(Math.max(a.max,b.max),root.val);
        
        return new Pair(newMin,newMax);
    }
}

class Pair{
    long min;
    long max;
    public Pair(long min,long max){
        this.min=min;
        this.max=max;
    }
}