import java.util.*;
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	  }
}
public class GoodNode {
private int count = 0;
    
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        helper(root, Integer.MIN_VALUE);
        return count;
    }
    
    private void helper(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            count++;
        }
        helper(root.left, Math.max(max, root.val));
        helper(root.right, Math.max(max, root.val));
    }
}
