package 二叉树;

//572. 另一棵树的子树
public class Main2 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

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

    }
}
