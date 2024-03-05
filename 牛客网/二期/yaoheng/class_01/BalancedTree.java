package 牛客网.二期.yaoheng.class_01;


import 牛客网.二期.yaoheng.TimeNumUtils;

/**
 * 空间复杂度： 该实现的空间复杂度是O(h)，其中h是二叉树的高度。在递归过程中，需要使用栈空间来存储每个递归调用的信息。
 *
 * 时间复杂度： 该实现的时间复杂度是O(nlogn)，其中n是二叉树中的节点数量。在判断每个节点是否平衡时，需要遍历整个二叉树，并对每个节点计算其子树的高度。
 *
 * 实现逻辑： 该实现使用递归的方式来判断二叉树是否平衡。对于每个节点，通过计算其左子树和右子树的高度差来判断是否平衡。如果高度差大于1，则返回false；否则，递归地判断左子树和右子树是否平衡。
 *
 * 目的： 目的是判断给定的二叉树是否平衡，即左右子树的高度差不超过1。
 *
 * 优劣势： 该实现的
 * 优势是简单直观，使用递归的方式实现。
 * 缺点是在判断每个节点是否平衡时，会重复计算子树的高度，导致时间复杂度较高。另外，该实现并没有对二叉树进行平衡的优化操作，只是判断是否平衡。如果需要进行平衡操作，可以考虑使用其他算法和数据结构。
 */


public class BalancedTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode node) {
        TimeNumUtils.inc();
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        boolean isBalanced = isBalanced(root);
        System.out.println("Is the tree balanced? " + isBalanced);
        TimeNumUtils.end();
    }
}

