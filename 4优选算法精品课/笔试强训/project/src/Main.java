public class Main {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.right = node3;

        System.out.println(maxDepth(node1));
    }
    public static int maxDepth(TreeNode root) {
        if(root.left == null || root.right == null) return 1;

        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = maxDepth(root.left);
        }

        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = maxDepth(root.right);
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
