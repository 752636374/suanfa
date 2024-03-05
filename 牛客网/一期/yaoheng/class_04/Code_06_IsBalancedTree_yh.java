package 牛客网.一期.yaoheng.class_04;

public class Code_06_IsBalancedTree_yh {
    static class Node {
        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        System.out.println(isBalanceTree(node));

        node.right.right.right = new Node(8);
        node.right.right.right.right = new Node(9);

        System.out.println(isBalanceTree(node));
    }

    /**
     * 判定左右两个树的高度相差是否超过1
     *
     * @param node
     * @return
     */
    private static boolean isBalanceTree(Node node) {
        Boolean[] b = new Boolean[]{true};
        getHeight(node, 0, b);
        return b[0];
    }

    private static Integer getHeight(Node node, Integer lev, Boolean[] b) {
        //为空则返回
        if (node == null) {
            return lev;
        }

        //左边的高度
        Integer left = getHeight(node.left, lev + 1, b);
        if (!b[0]) {
            return lev;
        }

        //右边的高度
        Integer right = getHeight(node.right, lev + 1, b);
        if (!b[0]) {
            return lev;
        }

        if (Math.abs(left - right) > 1) {
            b[0] = false;
        }

        //左右相差高度
        return Math.max(left,right);
    }
}
