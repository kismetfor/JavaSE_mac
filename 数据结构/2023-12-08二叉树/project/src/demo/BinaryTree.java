package demo;

public class BinaryTree {
    //穷举方式创建

    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    public TreeNode creatTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }
    //前序遍历
    void preOrder(TreeNode node) {
        if (node==null) {
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //中序遍历
    void inOrder(TreeNode node) {
        if (node==null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }
    //后序遍历
    void postOrder(TreeNode node) {
        if (node==null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }
    public static int nodeSize;

    /**
     * 获取树中节点的个数：遍历思路
     */
    void size(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.right)+size2(root.left)+1;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    void getLeafNodeCount1(TreeNode root) {
        if (root==null) {
            return;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
        if (root.left==null&& root.right==null) {
            leafSize++;
        }
    }

    /*
     获取叶子节点的个数：子问题
     */
    int getLeafNodeCount2(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (root.left==null&& root.right==null) {
            return 1;
        }
        return getLeafNodeCount2(root.left)+getLeafNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if (root==null) {
            return 0;
        }
        if (k==1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k-1)+
                getKLevelNodeCount(root.right, k-1);
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),
                getHeight(root.right))+1;
    }


    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val) {
        if (root==null) {
            return null;
        }
        if (root.val==val) {
            return root;
        }
        TreeNode findLeft = find(root.left, val);
        if (findLeft!=null) {
            return findLeft;
        }
        return find(root.right, val);
    }

    //层序遍历
    void levelOrder(TreeNode root) {

    }


    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        return true;
    }
}
