package 牛客网.二期.yaoheng.class_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 原理：MaxDistanceInTree函数用于计算给定树中两个节点之间的最远距离。
 * 它通过递归遍历树的每个节点，并计算每个节点的最大深度和最大距离。
 * 最大深度是从当前节点到子树的最远叶子节点的距离，最大距离是当前节点到其子树中的两个最远叶子节点的距离。
 * 根据这些计算结果，可以得到整个树的最远距离。
 * 应用场景：该函数可以用于计算树结构中的节点间的最远距离，例如树的直径，或者在网络结构中计算节点间的最短路径等。
 * 复杂度：时间复杂度为O(N)，其中N是树中的节点数，因为需要遍历每个节点。空间复杂度为O(H)，其中H是树的高度，因为递归调用会使用到函数调用栈的空间。
 * 测试方法：在测试方法中，创建一个树结构，并调用maxDistance函数计算树中的最远距离。然后打印结果进行验证。
 */
public class MaxDistanceInTree {
    private static class TreeNode {
        int val;
        List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    private static class Result {
        int maxDepth;//最大深度
        int maxDistance;//最大距离

        public Result(int maxDepth, int maxDistance) {
            this.maxDepth = maxDepth;
            this.maxDistance = maxDistance;
        }
    }

    public static int maxDistance(TreeNode root) {
        return helper(root).maxDistance;
    }

    private static Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);  // 如果根节点为空，返回深度和距离都为0的结果
        }

        int maxDepth = 0;  // 最大深度
        int maxDistance = 0;  // 最大距离

        for (TreeNode child : root.children) {  // 遍历每个子节点
            Result childResult = helper(child);  // 递归调用helper函数得到子节点的结果
            maxDepth = Math.max(maxDepth, childResult.maxDepth + 1);  // 更新最大深度
            maxDistance = Math.max(maxDistance, childResult.maxDistance);  // 更新最大距离
        }

        if (root.children.size() >= 2) {  // 如果子节点数量大于等于2
            maxDistance = Math.max(maxDistance, 2 + maxDepth - 1);  // 更新最大距离
        }

        return new Result(maxDepth, maxDistance);  // 返回最终结果
    }


    // 测试方法
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);
        node3.children.add(node6);
        node6.children.add(node7);

        int maxDistance = maxDistance(root);
        System.out.println("Max distance in the tree: " + maxDistance); // Output: 4
    }
}
