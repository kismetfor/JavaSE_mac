package 二叉树;

public class Main6 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.right != null) {
            if (root.left.val == root.right.val) {
                return isSymmetric(root.left) && isSymmetric(root.right);
            }
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
