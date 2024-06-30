package 二叉树;

public class Main4 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int a;
        if (leftHeight > rightHeight) {
            a = leftHeight-rightHeight;
        } else {
            a = rightHeight-leftHeight;
        }
        return a <= 1;
    }
    public int height(TreeNode root) {
        while (true) {
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.left;
            }
        }
    }
    public static void main(String[] args) {

    }
}
