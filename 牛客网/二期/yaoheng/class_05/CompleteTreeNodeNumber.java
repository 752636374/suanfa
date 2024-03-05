package 牛客网.二期.yaoheng.class_05;

/**
 * completeTreeNodeNumber函数用于计算给定完全二叉树中的节点数量。
 * 实现逻辑：
 * 首先，通过计算左子树的高度和右子树的高度来判断完全二叉树的性质。
 * 如果左子树的高度等于右子树的高度，那么说明左子树是满二叉树，节点数量为2^h - 1，其中h为左子树的高度。
 * 如果左子树的高度不等于右子树的高度，那么说明右子树是满二叉树，节点数量为2^h - 1，其中h为右子树的高度。
 * 注意：上述代码仅为示例，实际应用中可能需要根据具体情况对输入数据和算法进行调整。
 */


public class CompleteTreeNodeNumber {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            // 如果左子树高度等于右子树高度，说明左子树是满二叉树
            return (1 << leftHeight) - 1;
        } else {
            // 如果左子树高度不等于右子树高度，说明右子树是满二叉树
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
