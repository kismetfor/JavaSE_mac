package demo1;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = solution.buildTree(postorder, inorder);
        System.out.println(node.val);
        
    }
}
