package 二叉树;

public class Main5 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left-right) > 1) return false;
        return isBalanced(root.right) && isBalanced(root.left);
    }
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
}
