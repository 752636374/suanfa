package 牛客网.二期.yaoheng.class_05;

public class CompleteTreeNodeNumber_yh {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        System.out.println(getNumber(node));
    }

    private static Integer getNumber(Node node) {
        //判定节点
        if (node == null) {
            return 0;
        }
        //计算左边高度
        int left = getLeft(node);

        //计算右边高度
        int right = getRight(node);
        //对比高度

        if (left == right) {
            return (1 << left) - 1;
        } else {
            return getNumber(node.left)+getNumber(node.right)+1;
        }
    }

    private static int getRight(Node right) {
        int result = 0;
        while (right != null) {
            result++;
            right = right.right;
        }
        return result;
    }

    private static int getLeft(Node left) {
        int result = 0;
        while (left != null) {
            result++;
            left = left.left;
        }
        return result;
    }
}
