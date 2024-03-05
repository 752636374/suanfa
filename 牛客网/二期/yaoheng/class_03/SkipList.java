package 牛客网.二期.yaoheng.class_03;

import java.util.Random;

class SkipListNode {
    int value;
    SkipListNode[] next;

    public SkipListNode(int value, int level) {
        this.value = value;
        next = new SkipListNode[level];
    }
}

/**
 * 适用场景：
 * - 快速的插入、删除和查找操作：SkipList适用于需要高效执行这些操作的场景。它的性能比普通的有序链表要好，但比平衡二叉搜索树要简单。
 * - 并发环境：SkipList在并发环境中具有良好的性能，因为它的结构可以更容易地支持并发操作。
 * <p>
 * 优势：
 * - 快速的插入和删除：SkipList通过多层级的索引结构，可以在O(log n)的平均时间复杂度内插入和删除节点，与平衡二叉搜索树相比，插入和删除操作更简单。
 * - 高效的查找：SkipList的查找操作与有序链表类似，可以在O(log n)的平均时间复杂度内完成，相对于平衡二叉搜索树来说，查找操作更简单。
 * - 简单的实现：相较于平衡二叉搜索树，SkipList的实现更加简单，不需要维护平衡性。
 * <p>
 * 劣势：
 * - 空间占用：SkipList相对于普通的有序链表来说，需要额外的空间来存储层级索引的指针，因此在存储空间方面会有一定的开销。
 * - 不支持高效的范围查询：SkipList在查找范围内的节点时，需要从头节点开始遍历，无法像平衡二叉搜索树那样高效地进行范围查询。
 * <p>
 * 总结：
 * - SkipList适用于需要快速的插入、删除和查找操作的场景，尤其在并发环境中表现良好。
 * - 它的优势在于快速的插入和删除操作，以及相对简单的实现。然而，它的劣势在于空间占用较高，且不支持高效的范围查询。
 * - 在选择数据结构时，需要根据具体的需求和场景进行权衡和选择。
 */

public class SkipList {
    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5; // 节点升级的概率
    private SkipListNode head; // 头节点
    private int maxLevel; // 最大层级
    private int size; // 大小


    public SkipList() {
        head = new SkipListNode(Integer.MIN_VALUE, MAX_LEVEL);
        maxLevel = 1;
        size = 0;
    }

    // 随机生成节点层级
    private int randomLevel() {
        int level = 1;
        Random random = new Random();
        while (random.nextDouble() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    // 插入节点
    public void insert(int value) {
        // 生成一个随机的层数
        int level = randomLevel();

        // 如果随机的层数大于最大层数，则将层数设置为最大层数加1
        if (level > maxLevel) {
            level = maxLevel + 1;
        }

        // 创建一个新的跳表节点，传入值和层数
        SkipListNode newNode = new SkipListNode(value, level);

        // 创建一个数组来保存每一层需要更新的节点
        SkipListNode[] update = new SkipListNode[level];

        // 从头节点开始，逐层查找插入位置
        SkipListNode current = head;
        for (int i = level - 1; i >= 0; i--) {
            // 在当前层查找插入位置，直到找到大于等于插入值的节点
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            // 将每一层需要更新的节点保存到数组中
            update[i] = current;
        }

        // 在每一层插入新节点
        for (int i = 0; i < level; i++) {
            // 将新节点的下一个节点指向原先的下一个节点
            newNode.next[i] = update[i].next[i];
            // 将原先的节点的下一个节点指向新节点
            update[i].next[i] = newNode;
        }

        // 如果插入的层数大于最大层数，则更新最大层数
        if (level > maxLevel) {
            maxLevel = level;
        }

        // 增加跳表的大小
        size++;
    }

    // 删除节点
    public void delete(int value) {
        // 创建一个数组用于存储每个层级的更新节点
        SkipListNode[] update = new SkipListNode[maxLevel];

        // 从头节点开始遍历跳表，找到每个层级中小于给定值的最大节点
        SkipListNode current = head;
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            // 将每个层级的更新节点保存在数组中
            update[i] = current;
        }

        // 如果找到了要删除的节点，则执行删除操作
        if (current.next[0] != null && current.next[0].value == value) {
            SkipListNode toBeDeleted = current.next[0];
            // 从上层到下层，更新每个层级上的指针，跳过要删除的节点
            for (int i = 0; i < maxLevel; i++) {
                if (update[i].next[i] == toBeDeleted) {
                    update[i].next[i] = toBeDeleted.next[i];
                }
            }
            // 更新跳表的大小
            size--;
        }
    }

    // 查找节点是否存在
    public boolean contains(int value) {
        // 使用变量`current`将`head`的值初始化
        SkipListNode current = head;

        // 从最高层开始，迭代遍历跳表的每一层
        for (int i = maxLevel - 1; i >= 0; i--) {
            // 将`current`向右移动，直到下一个节点的值大于或等于`value`
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
        }

        // 检查最低层的下一个节点是否存在且具有与`value`相同的值
        return current.next[0] != null && current.next[0].value == value;
    }


    // 打印SkipList
    public void printSkipList() {
        // 从顶层开始遍历
        for (int i = maxLevel - 1; i >= 0; i--) {
            // 获取当前层的第一个节点
            SkipListNode current = head.next[i];
            // 打印当前层级
            System.out.print("Level " + (i + 1) + ": ");
            // 遍历当前层级的节点
            while (current != null) {
                // 打印节点的值
                System.out.print(current.value + " ");
                // 移动到下一个节点
                current = current.next[i];
            }
            // 打印换行符
            System.out.println();
        }
    }






    // 测试方法
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(3);
        skipList.insert(1);
        skipList.insert(5);
        skipList.insert(2);
        skipList.insert(4);

        skipList.printSkipList(); // 输出：Level 4: 1 2 3 4 5

        skipList.delete(2);

        skipList.printSkipList(); // 输出：Level 4: 1 3 4 5

        System.out.println(skipList.contains(4)); // 输出：true
        System.out.println(skipList.contains(2)); // 输出：false
    }
}
