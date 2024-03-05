package 牛客网.二期.yaoheng.class_01;

public class MaxDistanceInTree_yh {
    public static void main(String[] args) {
        // 创建一棵二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(getMxDistance(root));
    }

    private static int getMxDistance(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        getLength(root, max);
        return max[0];
    }

    private static int getLength(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = getLength(root.left, max);
        int right = getLength(root.right, max);

        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
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
