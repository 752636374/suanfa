package 牛客网.二期.yaoheng.class_01;

public class ContainsT2Topology_YH {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);
        n1.left.left = new TreeNode(4);
        n1.left.right = new TreeNode(5);
        n1.right.left = new TreeNode(6);
        n1.right.right = new TreeNode(7);

        TreeNode n2 = new TreeNode(1);
        n2.left = new TreeNode(2);
        n2.right = new TreeNode(3);

        System.out.println(contains(n1, n2));
    }

    private static boolean contains(TreeNode n1, TreeNode n2) {
        if (n2 == null) {
            return true;
        }

        if (n1 == null) {
            return false;
        }

        return isSame(n1, n2) || contains(n1.left, n2) || contains(n1.right, n2);
    }

    private static boolean isSame(TreeNode n1, TreeNode n2) {

        if (n2 == null) {
            return true;
        }

        if (n1 == null) {
            return false;
        }
        return (n1.val == n2.val) && isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }
}
