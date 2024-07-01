package 二叉树;

public class Main6 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree==null && rightTree == null) return true;
        if (leftTree==null || rightTree == null) return false;
        if (leftTree.val == rightTree.val) {
            return dfs(leftTree.left, rightTree.right) && dfs(leftTree.right, rightTree.left);
        }
        return false;
    }
    public void init() {

    }
}
