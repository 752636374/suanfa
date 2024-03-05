package 牛客网.二期.yaoheng.class_04;

public class BiggestSubBSTInTree_yh {
    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }

    class Result {
        int size;
        int min;
        int max;
        TreeNode treeNode;

        public Result(int size, int min, int max, TreeNode treeNode) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.treeNode = treeNode;
        }
    }

    public Result getResult(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        return bst(treeNode);
    }

    private Result bst(TreeNode treeNode) {
        if (treeNode == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE, null);
        }
        Result left = bst(treeNode.left);
        Result right = bst(treeNode.right);

        if (left.treeNode == treeNode.left && right.treeNode == treeNode.right
                && treeNode.val > left.max && treeNode.val < right.min) {
            int size = left.size + right.size + 1;
            int min = Math.min(left.min, treeNode.val);
            int max = Math.max(right.max, treeNode.val);
            return new Result(size, min, max, treeNode);
        } else {
            return left.size > right.size ? left : right;
        }
    }

    public static void main(String[] args) {
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

        BiggestSubBSTInTree_yh yh = new BiggestSubBSTInTree_yh();
        Result result = yh.getResult(root);
        System.out.println(result.size);
        System.out.println(result.treeNode.val);
    }
}
