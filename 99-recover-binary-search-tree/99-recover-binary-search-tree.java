class Solution {
  TreeNode x = null, y = null, pred = null;

  public void swap(TreeNode a, TreeNode b) {
    int tmp = a.val;
    a.val = b.val;
    b.val = tmp;
  }

  public TreeNode getRightMostNode(TreeNode left, TreeNode curr) {
    while (left.right != null && left.right != curr) left = left.right;
    return left;
  }

  public void findTwoSwapped(TreeNode root) {
    TreeNode curr = root;
    while (curr != null) {
      TreeNode left = curr.left;

      if (left == null) {
        //logic
        if (pred != null && curr.val < pred.val) {
          y = curr;
          if (x == null) x = pred;
        }
        pred = curr;
        curr = curr.right;
      } else {
        TreeNode rightMostNode = getRightMostNode(left, curr);

        if (rightMostNode.right == null) {
          //we need to create the thread
          rightMostNode.right = curr;
          curr = curr.left;
        } else {
          //we need to destroy the pre-existing thread
          rightMostNode.right = null;
          //logic
          if (pred != null && curr.val < pred.val) {
            y = curr;
            if (x == null) x = pred;
          }
          pred = curr;
          curr = curr.right;
        }
      }
    }
  }

  public void recoverTree(TreeNode root) {
    findTwoSwapped(root);
    swap(x, y);
  }
}