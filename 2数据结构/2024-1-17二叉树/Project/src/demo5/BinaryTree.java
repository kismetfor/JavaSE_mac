package demo5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    //穷举方式创建

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> retList = new LinkedList<List<Integer>>();
        if (root==null) {
            return retList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            size = queue.size();
            while (size!=0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                size--;
                if (cur.left!=null) {
                    queue.offer(cur.left);
                }
                if (cur.right!=null) {
                    queue.offer(cur.right);
                }
            }
            retList.add(list);
        }
        return retList;
    }
}