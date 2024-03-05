package 牛客网.二期.yaoheng.class_04;

/**
 * BiggestSubBSTInTree是一个用于找到二叉树中最大子二叉搜索树的算法。下面是对其应用场景、优劣势、时间空间复杂度以及实现逻辑的说明：
 * <p>
 * 应用场景：
 * <p>
 * BiggestSubBSTInTree可以应用于需要找到二叉树中最大子二叉搜索树的场景。例如，在二叉树中找到具有最大搜索树特性的子树，或者在二叉搜索树中找到最大的子树。
 * 优势：
 * <p>
 * BiggestSubBSTInTree算法可以在二叉树中高效地找到最大子二叉搜索树，提供了一种快速解决该问题的方法。
 * 劣势：
 * <p>
 * BiggestSubBSTInTree算法的实现可能相对复杂，需要对二叉树的结构和二叉搜索树的特性有一定的理解。
 * 时间复杂度：
 * <p>
 * BiggestSubBSTInTree算法的时间复杂度为O(N)，其中N是二叉树中节点的数量。
 * 空间复杂度：
 * <p>
 * BiggestSubBSTInTree算法的空间复杂度为O(H)，其中H是二叉树的高度。
 * 实现逻辑：
 * <p>
 * 定义一个辅助类Result，用于保存子树的信息，包括子树的最小值、最大值、节点数量以及子二叉搜索树的根节点。
 * 实现递归函数biggestSubBST，该函数接受一个二叉树节点作为参数，返回以该节点为根的子树的Result对象。
 * 在递归函数中，首先处理递归结束条件，即节点为空的情况，返回一个空的Result对象。
 * 然后，递归调用biggestSubBST函数处理左子树和右子树，并获取它们的Result对象。
 * 根据左子树和右子树的Result对象，计算当前节点所在子树的最小值、最大值和节点数量。
 * 判断当前节点是否满足二叉搜索树的特性，即当前节点的值大于左子树的最大值且小于右子树的最小值。
 * 如果当前节点满足二叉搜索树的特性，则更新最大子二叉搜索树的信息，包括最大子树的根节点和节点数量。
 * 最后，返回以当前节点为根的子树的Result对象。
 * 在主函数中，调用biggestSubBST函数处理整个二叉树，并获取最大子二叉搜索树的根节点和节点数量。
 */


public class BiggestSubBSTInTree {
    // Define binary tree node class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Define result class
    static class Result {
        TreeNode root; // Root node of the subtree
        int size; // Number of nodes in the subtree
        int min; // Minimum value in the subtree
        int max; // Maximum value in the subtree

        public Result(TreeNode root, int size, int min, int max) {
            this.root = root;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public Result biggestSubBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        return biggestSubBSTHelper(root);
    }

    /**
     * 该方法用于查找二叉树中最大的二叉搜索子树。
     *
     * @param root 二叉树的根节点
     * @return 包含最大二叉搜索子树信息的Result对象
     */
    private Result biggestSubBSTHelper(TreeNode root) {
        // 如果根节点为空，则返回一个包含默认值的Result对象
        if (root == null) {
            return new Result(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // 递归调用biggestSubBSTHelper方法，分别获取左子树和右子树的最大二叉搜索子树信息
        Result leftResult = biggestSubBSTHelper(root.left);
        Result rightResult = biggestSubBSTHelper(root.right);

        // 判断当前节点是否为二叉搜索树的根节点，并且满足二叉搜索树的条件
        if (leftResult.root == root.left && rightResult.root == root.right &&
                root.val > leftResult.max && root.val < rightResult.min) {
            // 计算当前节点为根的二叉搜索子树的大小、最小值和最大值
            int size = leftResult.size + rightResult.size + 1;
            int min = Math.min(root.val, leftResult.min);
            int max = Math.max(root.val, rightResult.max);
            // 返回包含当前节点为根的二叉搜索子树信息的Result对象
            return new Result(root, size, min, max);
        } else {
            // 返回左子树和右子树中较大的二叉搜索子树信息
            return leftResult.size > rightResult.size ? leftResult : rightResult;
        }
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(1);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(13);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(14);
        root.right.right.left = new TreeNode(20);
        root.right.right.right = new TreeNode(16);

        BiggestSubBSTInTree solution = new BiggestSubBSTInTree();
        Result results = solution.biggestSubBST(root);
        TreeNode result = results.root;
        System.out.println("The biggest subtree root is: " + result.val);
        System.out.println("The size of the biggest subtree is: " + results.size);
    }
}
