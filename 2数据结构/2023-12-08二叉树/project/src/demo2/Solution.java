package demo2;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return true;
    }
    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}