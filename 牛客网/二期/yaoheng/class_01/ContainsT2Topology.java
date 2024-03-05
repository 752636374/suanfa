package 牛客网.二期.yaoheng.class_01;



public class ContainsT2Topology {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 判断一棵树是否包含T2拓扑结构
     * @param root1 第一棵树的根节点
     * @param root2 第二棵树的根节点
     * @return 如果树root1包含树root2的T2拓扑结构，则返回true；否则返回false
     */
    public static boolean containsT2Topology(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return isSameTopology(root1, root2) || containsT2Topology(root1.left, root2) || containsT2Topology(root1.right, root2);
    }

    /**
     * 判断两棵树的拓扑结构是否相同
     * @param node1 第一棵树的当前节点
     * @param node2 第二棵树的当前节点
     * @return 如果两棵树的拓扑结构相同，则返回true；否则返回false
     */
    private static boolean isSameTopology(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return (node1.val == node2.val) && isSameTopology(node1.left, node2.left) && isSameTopology(node1.right, node2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        boolean containsT2 = containsT2Topology(root1, root2);
        System.out.println("Does root1 contain the T2 topology? " + containsT2);
    }
}
