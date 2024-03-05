package 牛客网.二期.yaoheng.class_03;

/**
 * 这个示例展示了一个基本的二叉搜索树的实现，包括插入、搜索和删除操作。二叉搜索树是一种有序的二叉树，其中每个节点的左子树的值都小于该节点的值，右子树的值都大于该节点的值。
 * <p>
 * 时间复杂度：
 * <p>
 * 插入操作的平均时间复杂度为O(log n)，最坏情况下为O(n)，其中n是树中节点的数量。
 * 搜索操作的平均时间复杂度为O(log n)，最坏情况下为O(n)，其中n是树中节点的数量。
 * 删除操作的平均时间复杂度为O(log n)，最坏情况下为O(n)，其中n是树中节点的数量。
 * 空间复杂度：
 * <p>
 * 空间复杂度取决于树中节点的数量。在最坏的情况下，树的高度为n，空间复杂度为O(n)。
 * 实现目的：
 * <p>
 * 二叉搜索树的主要目的是提供一种快速的数据结构，用于存储和检索有序数据。
 * 优劣势：
 * <p>
 * 优势：
 * 二叉搜索树提供快速的插入、搜索和删除操作。
 * 它可以保持数据的有序性，便于进行范围查询和排序操作。
 * 劣势：
 * 在最坏的情况下，二叉搜索树可能变得不平衡，导致操作的时间复杂度变为线性，而不是对数时间复杂度。
 * 对于有序插入的数据，二叉搜索树可能退化为链表，导致性能下降。
 * 应用场景：
 * <p>
 * 二叉搜索树适用于需要快速插入、搜索和删除有序数据的场景。
 * 它可以用于实现范围查询和排序操作。
 * 二叉搜索树还可以用于实现其他高级数据结构，例如平衡二叉搜索树（如AVL树和红黑树）和优先队列（如堆）。
 * 需要注意的是，二叉搜索树在某些情况下可能会退化为链表，导致性能下降。因此，在实际应用中，可能需要使用其他高级数据结构来解决这个问题。
 */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

    /**
     * 插入节点到二叉搜索树中
     *
     * @param root 二叉搜索树的根节点
     * @param val  要插入的节点值
     * @return 插入节点后的二叉搜索树的根节点
     */
    private TreeNode insertNode(TreeNode root, int val) {
        // 如果根节点为空，创建一个新节点并返回
        if (root == null) {
            return new TreeNode(val);
        }

        // 如果要插入的值小于根节点的值，递归插入到左子树中
        if (val < root.val) {
            root.left = insertNode(root.left, val);
        }
        // 如果要插入的值大于根节点的值，递归插入到右子树中
        else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }

        // 返回插入节点后的二叉搜索树的根节点
        return root;
    }

    public boolean search(int val) {
        return searchNode(root, val);
    }

    private boolean searchNode(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (val == root.val) {
            return true;
        } else if (val < root.val) {
            return searchNode(root.left, val);
        } else {
            return searchNode(root.right, val);
        }
    }

    public void delete(int val) {
        root = deleteNode(root, val);
    }

    /**
     * 从二叉搜索树中删除指定节点
     *
     * @param root 二叉搜索树的根节点
     * @param val  要删除的节点的值
     * @return 删除指定节点后的二叉搜索树的根节点
     */
    private TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        System.out.println(bst.search(4)); // 输出 true
        System.out.println(bst.search(6)); // 输出 false

        bst.delete(3);
        System.out.println(bst.search(3)); // 输出 false
    }
}
