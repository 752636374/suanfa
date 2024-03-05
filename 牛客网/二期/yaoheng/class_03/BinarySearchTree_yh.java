package 牛客网.二期.yaoheng.class_03;

public class BinarySearchTree_yh {

    static class TreeNode {
        Integer value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree_yh bst = new BinarySearchTree_yh();
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);

        System.out.println(bst.search(4)); // 输出 true
        System.out.println(bst.search(6)); // 输出 false

        bst.delete(3);
        System.out.println(bst.search(3)); // 输出 false

    }

    TreeNode root;

    private boolean search(int i) {
        return search(root, i);
    }

    private boolean search(TreeNode root, int i) {
        if (root == null) {
            return false;
        }
        if (root.value < i) {
            return search(root.right, i);
        } else if (root.value > i) {
            return search(root.left, i);
        }
        return true;
    }

    private void delete(int i) {
        root = delete(root, i);
    }

    private TreeNode delete(TreeNode root, int i) {
        if (root == null) {
            return null;
        }
        if (root.value > i) {
            root.left = delete(root.left, i);
        } else if (root.value < i) {
            root.right = delete(root.right, i);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode min = getMin(root);
            root.value = min.value;
            root.right = delete(root.right, min.value);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private void add(int i) {
        root = add(root, i);
    }

    private TreeNode add(TreeNode root, int i) {
        if (root == null) {
            return new TreeNode(i);
        }
        if (root.value > i) {
            root.left = add(root.left, i);
        } else if (root.value < i) {
            root.right = add(root.right, i);
        }
        return root;
    }
}
