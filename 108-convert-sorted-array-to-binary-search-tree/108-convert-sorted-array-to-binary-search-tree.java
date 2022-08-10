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
    public TreeNode sortedArrayToBST(int[] arr) {
        return solver(arr,0,arr.length-1);
    }
    
    public TreeNode solver(int arr[],int l,int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode rootNode=new TreeNode(arr[mid]);
        rootNode.left=solver(arr,l,mid-1);
        rootNode.right=solver(arr,mid+1,r);
        return rootNode;
    }
}