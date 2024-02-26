package deemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur!=null || !stack.isEmpty()) {
            while (cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right==null || prev == top.right) {
                stack.pop();
                list.add(top.val);
                prev = top;
            } else {
                cur = top.right;
            }
        }
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()) {
            while (cur!=null) {

                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()) {
            while (cur!=null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    public String tree2str(TreeNode root) {
        StringBuilder sbm = new StringBuilder();
        tree2strChild(root, sbm);
        return sbm.toString();
    }
    public void tree2strChild(TreeNode root, StringBuilder sbm) {
        if (root==null) {
            return;
        }
        sbm.append(root.val);
        if (root.left!=null) {
            sbm.append('(');
            tree2strChild(root.left, sbm);
            sbm.append(')');
        } else {
            if (root.right!=null) {
                //左空右不空
                sbm.append("()");
                sbm.append('(');
                tree2strChild(root.right, sbm);
                sbm.append(')');
            } else {
                //左右都为空
                return;
            }
        }
        if (root.right!=null && root.left!=null) {
            //左右都不为空
            sbm.append('(');
            tree2strChild(root.right, sbm);
            sbm.append(')');
        }
    }
}
