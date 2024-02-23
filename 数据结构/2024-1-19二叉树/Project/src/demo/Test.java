package demo;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.creatTree();
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode cur = solution.lowestCommonAncestor(root,p,q);
        System.out.println(cur.val);
    }
}
