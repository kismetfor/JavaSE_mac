package demo4;

import demo2.TreeNode;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.creatTree();
        binaryTree.levelOrder(root);
    }

}
