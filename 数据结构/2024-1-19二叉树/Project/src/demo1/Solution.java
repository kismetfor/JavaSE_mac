package demo1;

import java.util.Stack;

class Solution {
    public int postIndex;
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        postIndex = postorder.length-1;
        return buildTreeChild(postorder, inorder, 0, inorder.length-1);
    }


    /**
     *
     * @param postorder 前序遍历数组
     * @param inorder 中序遍历数组
     * @param inBegin 从这个地方开始找rootIndex
     * @param inEnd 从这个地方结束不找rootIndex
     * @return 根节点
     */
    public TreeNode buildTreeChild(int[] postorder,
                                   int[] inorder, int inBegin, int inEnd) {
        if (inBegin > inEnd || postIndex<0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int rootIndex = findIndex(root.val, inorder, inBegin, inEnd);
        postIndex--;
        root.right = buildTreeChild(postorder, inorder, rootIndex+1, inEnd);
        root.left = buildTreeChild(postorder, inorder, inBegin, rootIndex-1);
        return root;
    }
    public int findIndex(int val, int[] inorder, int inBegin, int inEnd) {
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        Stack<TreeNode> stackP = new Stack<>();
        getPath(root, p, stackP);
        Stack<TreeNode> stackQ = new Stack<>();
        getPath(root, q, stackQ);
        int i = 0;
        int sizeP = stackP.size();
        int sizeQ = stackQ.size();
        if (sizeP>sizeQ) {
            i = sizeP-sizeQ;
            while (i!=0) {
                i--;
                stackP.pop();
            }
        }else {
            i = sizeQ-sizeP;
            while (i!=0) {
                i--;
                stackQ.pop();
            }
        }
        while (!stackP.isEmpty()&&!stackQ.isEmpty()) {
            if (stackP.peek().equals(stackQ.peek())) {
                return stackP.peek();
            }
            stackP.pop();
            stackQ.pop();
        }
        return stackQ.peek();
    }
    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root==null) {
            return false;
        }
        stack.push(root);
        if (root.val==node.val) {
            return true;
        }
        boolean getLeft = getPath(root.left, node, stack);
        if (getLeft) {
            return true;
        }
        boolean getRight = getPath(root.right, node, stack);
        if (getRight) {
            return true;
        }
        stack.pop();
        return false;
    }
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
