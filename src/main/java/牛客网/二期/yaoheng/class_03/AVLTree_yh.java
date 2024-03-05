package 牛客网.二期.yaoheng.class_03;

public class AVLTree_yh {
    public static void main(String[] args) {
        AVLTree_yh avlTreeYh = new AVLTree_yh();
        avlTreeYh.add(10);
        avlTreeYh.add(20);
        avlTreeYh.add(30);
        avlTreeYh.add(40);
        avlTreeYh.add(50);
        avlTreeYh.add(25);
        avlTreeYh.preOrder(avlTreeYh.root);
    }

    private void preOrder(Node node) {
        // 如果节点不为空
        if (node != null) {
            // 打印节点值并加上空格
            System.out.print(node.value + " ");
            // 递归遍历左子树
            preOrder(node.left);
            // 递归遍历右子树
            preOrder(node.right);
        }
    }

    private void add(int node) {
        root = add(root, node);
    }

    private Node add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value > node.value) {
            node.right = add(node.right, value);
        } else if (value < node.value) {
            node.left = add(node.left, value);
        } else {
            return node;
        }

        //设置树高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        //获取平衡因子
        int balanceValue = getBalance(node);

        //右旋
        if (balanceValue > 1 && value < node.left.value) {
            return rightBalance(node);
        }

        //左旋
        if (balanceValue < -1 && value > node.right.value) {
            return leftBalance(node);
        }

        //先右旋，再左旋
        if (balanceValue > 1 && value > node.left.value) {
            node.left = leftBalance(node.left);
            return rightBalance(node);
        }

        //先左旋，再右旋
        if (balanceValue < -1 && value < node.right.value) {
            node.right = rightBalance(node.right);
            return leftBalance(node);
        }

        return node;

    }

    private Node rightBalance(Node a) {
        Node b = a.left;
        Node c = b.right;

        b.right = a;
        a.left = c;

        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;
        return b;
    }

    private Node leftBalance(Node a) {
        //设置
        Node b = a.right;
        Node c = b.left;

        b.left = a;
        a.right = c;

        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;

        return b;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node left) {
        if (left == null) {
            return 0;
        }
        return left.height;
    }


    Node root;

    static class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }
}
