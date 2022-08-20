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
    public int maxSumBST(TreeNode root) {
        solver(root);
        return res<0?0:res;
    }
    
    public int res=Integer.MIN_VALUE;
    
    public Pair solver(TreeNode root){
        
        if(root==null) return new Pair(Integer.MIN_VALUE/4,Integer.MAX_VALUE/4,0);
        
        Pair left=solver(root.left);
        Pair right=solver(root.right);
        int currSumOfSubtree=root.val+left.sum+right.sum;
        boolean isValidBST=false;
        if(root.val>left.max&&root.val<right.min){
            isValidBST=true;
            res=Math.max(res,currSumOfSubtree);
            // System.out.println(root.val+" "+res);
        }

        int min=Math.min(root.val,Math.min(left.min,right.min));
        int max=Math.max(root.val,Math.max(left.max,right.max));
        
        if(isValidBST){
            return new Pair(max,min,currSumOfSubtree);
        }else{
            return new Pair(Integer.MAX_VALUE/4,Integer.MIN_VALUE/4,0);
        }
    }
}

class Pair{
    int max;
    int min;
    int sum;
    public Pair(int max,int min,int sum){
        this.max=max;
        this.min=min;
        this.sum=sum;
    }
}