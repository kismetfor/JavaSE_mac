package demo;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.creatTree();
        System.out.println(root.val);
        binaryTree.preOrder(root);
        System.out.println();

        binaryTree.inOrder(root);
        System.out.println();

        binaryTree.postOrder(root);
    }
}
