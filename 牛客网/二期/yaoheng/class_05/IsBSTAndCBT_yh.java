package 牛客网.二期.yaoheng.class_05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * IsBSTAndCBT是一个逻辑判断函数，用于判断给定的二叉树是否同时满足二叉搜索树（Binary Search Tree，BST）和完全二叉树（Complete Binary Tree，CBT）的性质。
 *
 * 二叉搜索树（BST）的性质：
 *
 * 对于任意节点，其左子树中的所有节点值都小于它的值。
 * 对于任意节点，其右子树中的所有节点值都大于它的值。
 * 左子树和右子树都必须是二叉搜索树。
 * 完全二叉树（CBT）的性质：
 *
 * 对于任意节点，如果其有右子树而没有左子树，则不是完全二叉树。
 * 在层次遍历中，如果遇到一个节点既有左子树又有右子树，那么它的左子树和右子树都必须是满的。
 * IsBSTAndCBT函数的逻辑如下：
 *
 * 首先判断给定的二叉树是否满足二叉搜索树（BST）的性质，如果不满足则返回false。
 * 对于每个节点，检查其值是否大于左子树中的所有节点值，且小于右子树中的所有节点值。
 * 递归检查左子树和右子树是否也是二叉搜索树。
 * 如果二叉树满足二叉搜索树（BST）的性质，则继续判断是否满足完全二叉树（CBT）的性质。
 * 使用层次遍历（广度优先搜索）遍历二叉树。
 * 如果遇到一个节点既有左子树又有右子树，那么后续遍历的节点都必须是叶子节点（没有子节点）。
 * 如果遇到一个节点只有左子树而没有右子树，那么后续遍历的节点都必须是叶子节点（没有子节点）。
 * 如果给定的二叉树同时满足二叉搜索树（BST）和完全二叉树（CBT）的性质，则IsBSTAndCBT函数返回true，否则返回false。
 *
 * 请注意，上述逻辑描述是一种常见的实现方式，具体的实现可能会根据编程语言和数据结构的不同而有所差异。
 */
public class IsBSTAndCBT_yh {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        //初始化节点
        TreeNode t = new TreeNode(6);
        t.left = new TreeNode(2);
        t.right = new TreeNode(10);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(4);
        t.right.left = new TreeNode(8);
        t.right.right = new TreeNode(12);

        //判定是否是BST
        System.out.println(isBSTHelp(t));

        //判定是否是CBT
        System.out.println(isCBT(t));
    }

    private static boolean isCBT(TreeNode t) {
        if (t == null) {
            return true;
        }
        //使用栈存放数据
        Queue<TreeNode> stack = new LinkedList<>();
        boolean isEnd = false;
        stack.offer(t);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            //定义是否到达叶子节点
            if (isEnd && (node.left != null || node.right != null)) {
                return false;
            }

            //左子树入栈
            if (node.left != null) {
                stack.offer(node.left);
            }

            //右子树入栈
            if (node.right != null) {
                stack.offer(node.right);
            } else {
                isEnd = true;
            }
        }
        return true;

    }

    private static boolean isBSTHelp(TreeNode t) {
        return isBST(t, null, null);
    }

    private static boolean isBST(TreeNode t, Integer min, Integer max) {
        //判定节点是否为空
        if (t == null) {
            return true;
        }

        //判定节点：为空，值大小
        if ((min != null && t.value <= min) || (max != null && t.value >= max)) {
            return false;
        }
        return isBST(t.left, min, t.value) && isBST(t.right, t.value, max);
    }
}
