package 牛客网.二期.yaoheng.class_03;

/**
 * AVL 树是一种自平衡的二叉搜索树，通过在插入和删除节点时进行旋转操作，保持树的平衡。它的优势在于可以提供较快的插入、删除和搜索操作，并且可以保持树的高度平衡，从而提供较为稳定的性能。
 * <p>
 * 空间复杂度： AVL 树的空间复杂度为 O(n)，其中 n 是树中节点的数量。
 * <p>
 * 时间复杂度： 对于插入、删除和搜索操作，AVL 树的平均时间复杂度为 O(log n)，其中 n 是树中节点的数量。
 * <p>
 * 优势：
 * <p>
 * 提供较快的插入、删除和搜索操作。
 * 保持树的高度平衡，使得操作的时间复杂度稳定。
 * 劣势：
 * <p>
 * AVL 树的平衡调整操作可能会导致较多的旋转操作，增加了额外的开销。
 * 相对于其他平衡树结构，AVL 树的实现较为复杂。
 * 应用场景：
 * <p>
 * 需要频繁进行插入、删除和搜索操作，并且对操作的性能要求较高的场景。
 * 数据集合的大小较大，需要保持树的高度平衡，避免出现极端不平衡情况。
 * 目的：
 * <p>
 * 提供一种高效的数据结构，用于存储和操作有序数据集合。
 * 保持树的平衡，提供稳定的性能。
 */
class AVLTree {
    Node root;

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    Node rotateRight(Node y) {
        Node x = y.left;  // 将y的左子节点赋值给x
        Node T2 = x.right;  // 将x的右子节点赋值给T2

        x.right = y;  // 将y设置为x的右子节点
        y.left = T2;  // 将T2设置为y的左子节点

        y.height = Math.max(height(y.left), height(y.right)) + 1;  // 更新y的高度
        x.height = Math.max(height(x.left), height(x.right)) + 1;  // 更新x的高度

        return x;  // 返回x作为结果
    }


    Node rotateLeft(Node x) {
        Node y = x.right;  // 将x的右子节点保存为y
        Node T2 = y.left;  // 将y的左子节点保存为T2

        y.left = x;  // 将x设为y的左子节点
        x.right = T2;  // 将T2设为x的右子节点

        x.height = Math.max(height(x.left), height(x.right)) + 1;  // 更新x的高度
        y.height = Math.max(height(y.left), height(y.right)) + 1;  // 更新y的高度

        return y;  // 返回y作为旋转后的根节点
    }


    /**
     * 插入一个节点到二叉搜索树中
     *
     * @param node 二叉搜索树的根节点
     * @param val  要插入的节点的值
     * @return 更新后的二叉搜索树的根节点
     */
    Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val); // 如果节点为空，则创建一个新节点并返回
        }

        if (val < node.val) { // 如果插入值小于当前节点值
            node.left = insert(node.left, val); // 递归调用左子树插入
        } else if (val > node.val) { // 如果插入值大于当前节点值
            node.right = insert(node.right, val); // 递归调用右子树插入
        } else {
            return node; // 不允许插入重复值，返回当前节点
        }

        node.height = 1 + Math.max(height(node.left), height(node.right)); // 更新节点高度

        int balanceFactor = getBalanceFactor(node); // 获取节点的平衡因子

        if (balanceFactor > 1 && val < node.left.val) { // 如果平衡因子大于1且插入值小于左子节点的值
            return rotateRight(node); // 进行右旋转操作
        }

        if (balanceFactor < -1 && val > node.right.val) { // 如果平衡因子小于-1且插入值大于右子节点的值
            return rotateLeft(node); // 进行左旋转操作
        }

        if (balanceFactor > 1 && val > node.left.val) { // 如果平衡因子大于1且插入值大于左子节点的值
            node.left = rotateLeft(node.left); // 先对左子节点进行左旋转
            return rotateRight(node); // 再对当前节点进行右旋转
        }

        if (balanceFactor < -1 && val < node.right.val) { // 如果平衡因子小于-1且插入值小于右子节点的值
            node.right = rotateRight(node.right); // 先对右子节点进行右旋转
            return rotateLeft(node); // 再对当前节点进行左旋转
        }

        return node; // 返回当前节点
    }


    void preOrder(Node node) {
        // 如果节点不为空
        if (node != null) {
            // 打印节点值并加上空格
            System.out.print(node.val + " ");
            // 递归遍历左子树
            preOrder(node.left);
            // 递归遍历右子树
            preOrder(node.right);
        }
    }


    static class Node {
        int val;
        int height;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.height = 1;
        }
    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal of the constructed AVL tree is:");
        tree.preOrder(tree.root);
    }
}
