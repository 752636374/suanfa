package 牛客网.二期.yaoheng.class_01;

import 牛客网.二期.yaoheng.TimeNumUtils;

public class BalancedTree_yh {
    //定义树
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(isBalance(root));
        TimeNumUtils.end();
        ;
    }

    private static boolean isBalance(TreeNode root) {
        return getHeigth(root) != -1;
    }

    private static int getHeigth(TreeNode root) {
        TimeNumUtils.inc();
        if (root == null) {
            return 0;
        }
        int left = getHeigth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getHeigth(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(right - left) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
