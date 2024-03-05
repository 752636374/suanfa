package 牛客网.二期.yaoheng.class_05;

import java.util.LinkedList;
import java.util.Queue;



/**
 * 应用场景： IsBSTAndCBT 类可以在需要判断二叉树是否为二叉搜索树（BST）和完全二叉树（CBT）的场景中使用。
 * <p>
 * 作用：
 * <p>
 * isBST 方法用于判断给定二叉树是否为二叉搜索树。
 * isCBT 方法用于判断给定二叉树是否为完全二叉树。
 * 复杂度：
 * <p>
 * 对于 isBST 方法，时间复杂度为 O(n)，其中 n 是二叉树中节点的数量。
 * 对于 isCBT 方法，时间复杂度为 O(n)，其中 n 是二叉树中节点的数量。
 * 优势：
 * <p>
 * 简单易懂，并且通过递归和队列的方式实现了高效的判断算法。
 * 可以准确判断给定的二叉树是否为二叉搜索树和完全二叉树。
 * 劣势：
 * <p>
 * 仅适用于二叉树的判断，对于其他类型的树结构不适用。
 * 对于非二叉搜索树和非完全二叉树的二叉树，判断结果可能不准确。
 */

public class IsBSTAndCBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static boolean isBST(TreeNode root) {
        return isBSTHelper(root, null, null);
    }

    /**
     * 判断给定的二叉树是否为二叉搜索树
     *
     * @param node 当前节点
     * @param min  当前节点允许的最小值
     * @param max  当前节点允许的最大值
     * @return 如果二叉树是二叉搜索树，则返回true；否则返回false
     */
    private static boolean isBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isBSTHelper(node.left, min, node.val) && isBSTHelper(node.right, node.val, max);
    }

    /**
     * 判断给定的二叉树是否为完全二叉树。
     *
     * @param root 二叉树的根节点
     * @return 如果是完全二叉树，则返回true；否则返回false
     */
    public static boolean isCBT(TreeNode root) {
        // 如果根节点为空，则为完全二叉树
        if (root == null) {
            return true;
        }

        // 使用队列来进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 标记是否已经找到叶节点
        boolean leafFound = false;

        // 将根节点入队
        queue.offer(root);

        // 层序遍历
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 如果已经找到叶节点，并且当前节点的左右子节点不为空，则不是完全二叉树
            if (leafFound && (node.left != null || node.right != null)) {
                return false;
            }

            // 将左子节点入队
            if (node.left != null) {
                queue.offer(node.left);
            }

            // 将右子节点入队，如果右子节点为空，则标记已经找到叶节点
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                leafFound = true;
            }
        }

        // 遍历结束，没有发现不符合完全二叉树定义的情况，则是完全二叉树
        return true;
    }


    // Testing the IsBSTAndCBT class
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        boolean isBST = isBST(root);
        boolean isCBT = isCBT(root);

        System.out.println("Is BST: " + isBST);
        System.out.println("Is CBT: " + isCBT);
    }
}
