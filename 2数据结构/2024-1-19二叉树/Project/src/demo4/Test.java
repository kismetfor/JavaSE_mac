package demo4;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.creatTree();
        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        System.out.println(binaryTree.getPath(root, root.left, stack));
        System.out.println(stack);
    }

}
