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
class BSTIterator {

    Stack<TreeNode> stack;
    List<Integer> list;
    int pt;
    TreeNode last;
    public BSTIterator(TreeNode root) {
        this.stack=new Stack<TreeNode>();
        this.list=new ArrayList<>();
        this.pt=-1;
        this.last=root;
    }
    
    public boolean hasNext() {
        return (!stack.isEmpty()||last!=null||pt<list.size()-1);
    }
    
    public int next() {
        pt++;
        
        if(pt==list.size()){
            
            while(last!=null){
                stack.push(last);
                last=last.left;
            }
            
            TreeNode curr=stack.pop();
            last=curr.right;
            list.add(curr.val);
        }
        
        return list.get(pt);
    }
    
    public boolean hasPrev() {
        return pt>0;
    }
    
    public int prev() {
        pt--;
        return list.get(pt);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */