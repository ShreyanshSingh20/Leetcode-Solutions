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
    public TreeNode str2tree(String str) {
        char c[]=str.toCharArray();
        if(c.length==0) return null;
        Stack<TreeNode> s=new Stack<>();
        
        int i=0;
        while(i<c.length){
            if(c[i]=='(') {i++;continue;}
            else if(c[i]==')'){
                i++;
                s.pop();
            }else{
                StringBuilder sb=new StringBuilder();
                while(i<c.length&&(c[i]=='-'||(c[i]>=48&&c[i]<=57))){
                    sb.append(c[i]);
                    i++;
                }
                int val=Integer.parseInt(sb.toString());
                TreeNode newNode=new TreeNode(val);
                if(s.isEmpty()) {s.push(newNode); continue;}
                if(s.peek().left==null) s.peek().left=newNode;
                else if(s.peek().right==null) s.peek().right=newNode;
                s.push(newNode);
            }
        }
        
        return s.peek();
    }
}