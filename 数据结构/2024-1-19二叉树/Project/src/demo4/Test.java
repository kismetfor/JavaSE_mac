package demo4;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.creatTree();
        binaryTree.levelOrder(root);
        System.out.println(binaryTree.isCompleteTree(root));
    }

}
