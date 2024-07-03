package 二叉树;

import com.sun.source.tree.Tree;

public class Main7 {
    public static void main(String[] args) {

    }
    public static Tree chuangjian(String string) {
        TreeNode root = null;
        char[] chars = string.toCharArray();
        for (char ch:
             chars) {
            if (ch != '#') {
                if (root == null) {
                    root.val = ch;
                } else {

                }
            } else {

            }
        }
    }
}
