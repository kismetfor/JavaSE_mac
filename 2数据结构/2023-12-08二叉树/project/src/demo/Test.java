package demo;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.creatTree();
        /*System.out.println(root.val);
        binaryTree.preOrder(root);
        System.out.println();

        binaryTree.inOrder(root);
        System.out.println();

        binaryTree.postOrder(root);*/

        /*binaryTree.size(root);
        System.out.println(BinaryTree.nodeSize);*/

        System.out.print("节点个数: ");
        System.out.println(binaryTree.size2(root));

        System.out.print("叶子节点个数: ");
        /*binaryTree.getLeafNodeCount1(root);
        System.out.println(BinaryTree.leafSize);*/
        System.out.println(binaryTree.getLeafNodeCount2(root));

        System.out.print("第3层节点数: ");
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));

        System.out.print("获取二叉树的高度: ");
        System.out.println(binaryTree.getHeight(root));

        System.out.print("检测值为value的元素是否存在: ");
        BinaryTree.TreeNode node = binaryTree.find(root, 'K');
        if (node==null) {
            System.out.println("null");
        } else {
            System.out.println(node.val);
        }
    }
}
