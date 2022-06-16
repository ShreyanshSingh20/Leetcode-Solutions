/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.right==null){
            if(node.parent==null) return null;
            Node currNode=node;
            while(node.parent!=null){
                if(node.parent.val>currNode.val){
                    return node.parent;
                } 
                node=node.parent;
            }
            return null;
        }
        
        node=node.right;
        while(node.left!=null&&node!=null){
            node=node.left;
        }
        return node;
    }
}