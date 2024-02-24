package demo;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
