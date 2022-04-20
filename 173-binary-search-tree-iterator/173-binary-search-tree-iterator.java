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

    int ptr;
    TreeNode root;
    Stack<TreeNode> stack;
    List<Integer> list;
    public BSTIterator(TreeNode root) {
        this.ptr=-1;
        this.root=root;
        stack=new Stack<>();
        list=new ArrayList<>();
    }
    
    public int next() {
        ptr++;
        if(ptr==list.size()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode curr=stack.pop();
            list.add(curr.val);
            root=curr.right;
        }
        
        return list.get(ptr);
    }
    
    public boolean hasNext() {
        return (!stack.isEmpty()||root!=null);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */