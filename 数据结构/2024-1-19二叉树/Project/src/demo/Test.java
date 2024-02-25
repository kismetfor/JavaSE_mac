package demo;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = solution.buildTree(preorder, inorder);
        System.out.println(node);
        System.out.println("=====");
        TreeNode root = solution.creatTree();
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode cur = solution.lowestCommonAncestor(root,p,q);
        System.out.println(cur.val);

        /*Stack<TreeNode> stack = new Stack<>();
        solution.getPath(root, root.left.right.right, stack);
        System.out.println();*/

        TreeNode cur1 = solution.lowestCommonAncestor1(root,p,q);
        System.out.println(cur1.val);
    }
}
