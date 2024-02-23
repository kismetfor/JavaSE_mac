package demo;

import demo4.BinaryTree;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val==p.val||root.val==q.val) {
            return root;
        }
        TreeNode left = null;
        if (root.left!=null) {
            left = lowestCommonAncestor(root.left, p, q);
        }
        TreeNode right = null;
        if (root.right!=null) {
            right = lowestCommonAncestor(root.right, p, q);
        }
        if (left==null&&right==null) {
            return null;
        }
        if (right!=null) {
            return right;
        }
        return left;
    }
    public TreeNode creatTree() {
        TreeNode A = new TreeNode(3);
        TreeNode B = new TreeNode(5);
        TreeNode C = new TreeNode(1);
        TreeNode D = new TreeNode(6);
        TreeNode E = new TreeNode(2);
        TreeNode F = new TreeNode(0);
        TreeNode G = new TreeNode(8);
        TreeNode J = new TreeNode(7);
        TreeNode K = new TreeNode(4);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.left = J;
        E.right = K;
        return A;
    }
}
