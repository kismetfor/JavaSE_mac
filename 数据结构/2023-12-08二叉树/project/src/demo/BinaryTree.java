package demo;

public class BinaryTree {
    //穷举方式创建

    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    public TreeNode creatTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }
    //前序遍历
    void preOrder(TreeNode node) {
        if (node==null) {
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //中序遍历
    void inOrder(TreeNode node) {
        if (node==null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }
    //后序遍历
    void postOrder(TreeNode node) {
        if (node==null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }
}
