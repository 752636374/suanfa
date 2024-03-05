package 牛客网.二期.yaoheng.class_01;

/**
 * 代码说明：
 *
 * MaxDistanceInTree 类实现了一个 getMaxDistance 方法，用于计算二叉树中任意两个节点之间的最大距离。
 * depth 方法递归计算以当前节点为根节点的子树的深度，并更新最大距离。
 * main 方法中创建了一棵二叉树，并调用 getMaxDistance 方法来获取最大距离。
 * 时间复杂度： 该实现的时间复杂度为 O(N)，其中 N 表示二叉树的节点数量。在遍历二叉树的过程中，每个节点都只会被访问一次。
 *
 * 空间复杂度： 该实现的空间复杂度为 O(H)，其中 H 表示二叉树的高度。在递归调用 depth 方法的过程中，系统调用栈的最大深度为二叉树的高度。
 *
 * 实现目的： 该实现的目的是计算二叉树中任意两个节点之间的最大距离。最大距离定义为两个节点之间的边数，而不是节点数。
 *
 * 优点：
 *
 * 时间复杂度较低：该实现的时间复杂度为 O(N)，其中 N 表示二叉树的节点数量。在遍历二叉树的过程中，每个节点都只会被访问一次。
 * 空间复杂度较低：该实现的空间复杂度为 O(H)，其中 H 表示二叉树的高度。在递归调用 depth 方法的过程中，系统调用栈的最大深度为二叉树的高度。
 * 缺点：
 *
 * 仅适用于二叉树：该实现仅适用于二叉树，无法处理其他类型的树结构。
 * 不支持节点之间的具体路径：该实现只计算最大距离，未提供节点之间的具体路径信息。如果需要获取具体路径，需要进行额外的处理。
 */
public class MaxDistanceInTree {
    private int maxDistance;

    public int getMaxDistance(TreeNode root) {
        maxDistance = 0;
        depth(root);
        return maxDistance;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        maxDistance = Math.max(maxDistance, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // 创建一棵二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        MaxDistanceInTree maxDistanceInTree = new MaxDistanceInTree();
        int maxDistance = maxDistanceInTree.getMaxDistance(root);
        System.out.println("Max distance in the tree: " + maxDistance);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}


