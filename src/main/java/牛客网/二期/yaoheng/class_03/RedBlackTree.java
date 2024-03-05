package 牛客网.二期.yaoheng.class_03;

/**
 * 使用场景：
 *
 * 红黑树适用于需要高效地进行插入、删除和查找操作，并且需要维持有序性的情况。它在许多编程语言和库中被广泛应用，例如C++的STL中的map和set，Java的TreeMap和TreeSet等。红黑树常用于实现有序映射、有序集合以及范围查找等场景。
 * 优势：
 *
 * 平衡性：红黑树通过自平衡的操作保持树的平衡，确保树的高度保持在较小的范围内，从而保证了插入、删除和查找操作的时间复杂度为O(log n)。
 * 有序性：红黑树的节点按照特定的排序规则进行排列，可以快速地进行范围查找、最小值和最大值查找等操作。
 * 动态性：红黑树支持动态地插入和删除操作，可以方便地对数据集合进行更新。
 * 劣势：
 *
 * 相对复杂：相比于其他简单的数据结构，红黑树的实现较为复杂，需要维护节点的颜色、旋转操作等，实现起来较为繁琐。
 * 空间开销：红黑树需要为每个节点额外存储颜色信息，相比于普通二叉搜索树，会增加一定的空间开销。
 * 总结：红黑树适用于需要高效地进行插入、删除和查找操作，并且需要维持有序性的情况。它具有平衡性、有序性和动态性的优势，但相对复杂且有一定的空间开销。
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    // 获取节点的大小
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    // 判断节点是否为红色
    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    // 左旋转
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    // 右旋转
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    // 颜色翻转
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // 插入操作
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK; // 根节点始终为黑色
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, RED, 1);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    // 搜索操作
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    // 测试方法
    public static void main(String[] args) {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<>();

        // 插入操作
        rbt.put(5, "Value 5");
        rbt.put(3, "Value 3");
        rbt.put(8, "Value 8");
        rbt.put(2, "Value 2");
        rbt.put(4, "Value 4");
        rbt.put(7, "Value 7");
        rbt.put(9, "Value 9");

        // 搜索操作
        System.out.println(rbt.get(5)); // Output: Value 5
        System.out.println(rbt.get(2)); // Output: Value 2
        System.out.println(rbt.get(9)); // Output: Value 9
        System.out.println(rbt.get(6)); // Output: null
    }
}
