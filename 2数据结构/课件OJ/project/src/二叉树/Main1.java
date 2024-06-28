package 二叉树;



public class Main1 {
    /**
     * O(m*n)
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root==null) {
            return false;
        }
      if (isSameTree(root, subRoot)) {
                return true;
            }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }
    public boolean isSame(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                if (isSame(p.left, q.left)) {
                    return isSame(p.right, q.right);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else if (p == null && q != null || p != null && q == null) {
            return false;
        } else {
            //都为空
            return true;
        }
    }

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        TreeNode p = main1.chushi();
        TreeNode q = main1.chushi();
        main1.isSameTree(p,q);
    }
    public TreeNode chushi() {
        TreeNode head = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        head.left = a;
        head.right = b;
        return head;
    }
}
