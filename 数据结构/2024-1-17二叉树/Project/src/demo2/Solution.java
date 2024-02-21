package demo2;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {return true;}
        return isSymmetricChild(root.left, root.right);
    }
    boolean isSymmetricChild(TreeNode lt, TreeNode rt) {
        if (lt==null&&rt==null) {
            return true;
        }
        if (lt==null&&rt!=null || lt!=null&&rt==null) {
            return false;
        }
        if (lt.val!=rt.val) {
            return false;
        }
        return isSymmetricChild(lt.left, rt.right)&&
                isSymmetricChild(lt.right, rt.left);
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        return (getHeight(root)==-1);
    }
    public int getHeight(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if (leftH==-1 || rightH==-1) {
            return -1;
        }
        if (leftH>=0 && rightH >=0 &&Math.abs(leftH-rightH) <= 1) {
            return Math.max(leftH, rightH)+1;
        }
        return -1;
    }
}