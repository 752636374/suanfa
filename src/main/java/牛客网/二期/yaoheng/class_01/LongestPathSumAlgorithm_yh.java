package 牛客网.二期.yaoheng.class_01;

public class LongestPathSumAlgorithm_yh {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        //创建树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //求最长路径和
        int value = getLongestPathSum(root);
        System.out.println(value);
    }

    private static int getLongestPathSum(TreeNode treeNode) {
        //判定
        if (treeNode == null) {
            return 0;
        }

        //设置最大值
        int[] maxValue = {Integer.MIN_VALUE};
        //查询最大值
        getMax(treeNode, maxValue);

        //返回
        return maxValue[0];
    }

    private static int getMax(TreeNode treeNode, int[] maxValue) {
        //设置终止条件
        if (treeNode == null) {
            return 0;
        }

        //递归调用
        int left = getMax(treeNode.left, maxValue);
        int right = getMax(treeNode.right, maxValue);

        //执行逻辑
        int current = Math.max(treeNode.value, Math.max(treeNode.value + left, treeNode.value + right));
        maxValue[0] = Math.max(maxValue[0], Math.max(current, treeNode.value + left + right));
        return current;
    }
}
