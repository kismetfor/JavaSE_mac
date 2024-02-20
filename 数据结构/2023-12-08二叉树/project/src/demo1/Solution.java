package demo1;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root==null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }if (isSameTree(root.left, subRoot)) {
            return true;
        }if (isSameTree(root.right, subRoot)) {
            return true;
        }
        return  false ;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null || p!=null&&q==null) {
            return false;
        }
        if (p==null&&q==null) {
            return true;
        }
        if (p.val!=q.val) {
                return false;
            }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}