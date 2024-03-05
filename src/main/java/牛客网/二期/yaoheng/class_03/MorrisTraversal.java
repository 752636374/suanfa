package 牛客网.二期.yaoheng.class_03;


/**
 * 时间复杂度：Morris Traversal的时间复杂度为O(n)，其中n是二叉树中的节点数。
 * 因为每个节点最多被访问两次，而每次访问的时间复杂度为O(1)。
 *
 * 在上述代码中，我们实现了Morris Traversal的中序遍历方法morrisInorderTraversal。
 * 该方法使用了迭代的方式，通过修改指针的指向来实现遍历。
 * 我们还添加了一个简单的测试方法，创建了一个二叉树并进行中序遍历的测试。
 *
 * 请注意，Morris Traversal会修改二叉树的结构，将节点的右子树的某个叶子节点的右指针指向当前节点，以便在遍历完成后能回溯到当前节点。
 * 在应用该算法时，需要确保二叉树结构可以被修改。
 *
 * Morris Traversal的主要思想如下：
 *
 * 初始化当前节点为根节点。
 * 初始化当前节点为根节点。
 * 如果当前节点没有左子树，直接访问当前节点并进入右子树。
 * 如果当前节点有左子树，找到当前节点的前驱节点（左子树中的最右节点）。
 * 如果前驱节点的右指针为空，将其右指针指向当前节点，然后进入左子树。
 * 如果前驱节点的右指针指向当前节点，说明左子树已经遍历完毕，将其右指针恢复为空，访问当前节点并进入右子树。
 * 重复步骤2和步骤3，直到遍历完整个二叉树。
 */
public class MorrisTraversal {
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

    public void morrisInorderTraversal(TreeNode root) {
        TreeNode current = root; // 创建一个指向根节点的指针

        while (current != null) { // 循环直到当前节点为空
            if (current.left == null) { // 如果当前节点的左子树为空
                System.out.print(current.val + " "); // 输出当前节点的值
                current = current.right; // 将当前节点移动到右子节点
            } else { // 如果当前节点的左子树不为空
                TreeNode predecessor = current.left; // 创建一个指向当前节点左子树的指针
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right; // 找到当前节点的前驱节点
                }

                if (predecessor.right == null) { // 如果前驱节点的右子节点为空
                    predecessor.right = current; // 将前驱节点的右子节点指向当前节点
                    current = current.left; // 将当前节点移动到左子节点
                } else { // 如果前驱节点的右子节点不为空
                    predecessor.right = null; // 将前驱节点的右子节点置为空
                    System.out.print(current.val + " "); // 输出当前节点的值
                    current = current.right; // 将当前节点移动到右子节点
                }
            }
        }
    }

    // 测试方法
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        MorrisTraversal morrisTraversal = new MorrisTraversal();
        System.out.println("Inorder Traversal:");
        morrisTraversal.morrisInorderTraversal(root);
    }
}
