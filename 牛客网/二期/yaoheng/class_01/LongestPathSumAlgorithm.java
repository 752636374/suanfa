package 牛客网.二期.yaoheng.class_01;

/**
 * 目的： 该算法的目的是计算给定二叉树中的最长路径和。
 * <p>
 * 时间复杂度： 该算法的时间复杂度是 O(n)，其中 n 是二叉树中节点的数量。算法通过遍历二叉树的每个节点一次来计算最长路径和。
 * <p>
 * 空间复杂度： 该算法的空间复杂度是 O(h)，其中 h 是二叉树的高度。在递归调用过程中，使用了系统栈空间，栈的深度取决于二叉树的高度。
 * <p>
 * 实现逻辑： 在示例中，定义了一个内部静态类 TreeNode，表示二叉树的节点。然后定义了一个静态变量 maxSum，用于存储最长路径和的值。在方法 longestPathSum 中，首先将 maxSum 初始化为最小整数值。然后通过调用辅助方法 calculatePathSum 来计算路径和，并更新 maxSum。最后返回 maxSum 的值。
 * <p>
 * 辅助方法 calculatePathSum 用于计算以给定节点为路径起点的最长路径和。在方法内部，首先处理基本情况，如果节点为空，则路径和为 0。然后递归调用自身来计算左子树和右子树的最长路径和。根据当前节点的值和左右子树的最长路径和，计算当前节点为起点的最长路径和，并与全局最长路径和进行比较，更新 maxSum。最后返回当前节点为起点的最长路径和。
 * <p>
 * 实现原理： 该算法使用递归的方式来计算二叉树中的最长路径和。通过深度优先搜索遍历二叉树的每个节点，计算以每个节点为根节点的最长路径和，并更新全局最长路径和。
 * <p>
 * 优劣势：
 * <p>
 * 优势：该算法在计算最长路径和时，只需遍历二叉树的每个节点一次，具有较高的效率。并且通过使用全局变量 maxSum，可以避免传递参数和创建额外的数据结构，最小化了空间复杂度。
 * 劣势：该算法使用递归调用，对于非常高的二叉树可能会导致栈溢出的问题。此外，该算法只能计算二叉树中的最长路径和，无法获取其他统计信息。在实际应用中，可能需要考虑使用迭代或其他优化技巧来处理大规模的二叉树。
 */
public class LongestPathSumAlgorithm {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int longestPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] maxSum = {Integer.MIN_VALUE};
        calculatePathSum(root, maxSum);
        return maxSum[0];
    }

    private static int calculatePathSum(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = calculatePathSum(node.left, maxSum);
        int rightSum = calculatePathSum(node.right, maxSum);

        // 计算路径和
        int currentSum = Math.max(node.val, Math.max(node.val + leftSum, node.val + rightSum));

        // 更新最大路径和
        maxSum[0] = Math.max(maxSum[0], Math.max(currentSum, node.val + leftSum + rightSum));

        return currentSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int longestSum = longestPathSum(root);
        System.out.println("Longest path sum: " + longestSum);
    }
}
