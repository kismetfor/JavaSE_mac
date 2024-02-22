package demo3;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            inorder(creat(str));
        }
    }
    static int i;
    static TreeNode creat(String str) {
        TreeNode root = null;
        if (str.charAt(i)!='#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = creat(str);
            root.right = creat(str);
            return root;
        } else {
            i++;
        }
        return root;
    }
    static void inorder(TreeNode root) {
        if (root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
}