package demo;

public class BinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode root;
    boolean search(int val) {
        TreeNode cur = root;
        while (cur!=null) {
            if (cur.val==val) {
                return true;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }
    void insert(int val) {
        if (root==null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur!=null) {
            parent = cur;
            if (val<cur.val) {
                cur = cur.left;
            } else if (val > cur.val){
                cur = cur.right;
            } else {
                return;
            }
        }
        cur = new TreeNode(val);
        if (val > parent.val) {
            parent.right = cur;
        } else {
            parent.left = cur;
        }
    }
    void remove(int val) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur!=null) {
            parent = cur;
            if (val > cur.val) {
                cur = cur.right;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                break;
            }
        }
        removeVal(parent, cur);
    }
    void removeVal(TreeNode parent, TreeNode cur) {
        if (cur==null) {
            return;
        }
        if (cur.left==null && cur.right!=null) {
            if (cur==root) {
                root = cur.right;
            } else if (parent.left==cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
            return;
        }
        if (cur.right==null && cur.left!=null) {
            if (cur==root) {
                root = cur.left;
            } else if (parent.left==cur) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
            return;
        }
        TreeNode t = cur.right;
        TreeNode tp = cur;
        while (t.left!=null) {
            tp = t;
            t = t.left;
        }
        cur.val = t.val;
        if (tp.left==t) {
            tp.left = t.right;
        } else {
            tp.right = t.right;
        }
    }
}
