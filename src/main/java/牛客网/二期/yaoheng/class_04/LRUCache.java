package 牛客网.二期.yaoheng.class_04;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现过程：
 *
 * 创建一个双向链表的节点类Node，包含键值对的键key和值value，以及前驱节点prev和后继节点next。
 * 在LRUCache类中定义私有成员变量capacity表示缓存容量，cache作为哈希表用于存储缓存数据，head和tail分别作为链表头部和尾部的哨兵节点。
 * 初始化LRUCache对象时，设置缓存容量，并初始化哈希表和链表。
 * 实现get方法，通过键获取对应的节点，如果存在则将节点移动到链表头部，并返回节点的值；否则返回null。
 * 实现put方法，首先检查键是否已存在于缓存中，如果存在则更新节点的值，并将节点移动到链表头部；如果不存在，则创建新的节点并添加到链表头部和哈希表中。然后检查缓存容量是否超过限制，如果超过则删除链表尾部的节点，并从哈希表中移除对应的键。最后，更新缓存中的键值对。
 * 实现moveToHead方法，将指定节点移动到链表头部，即将节点从链表中移除并添加到链表头部。
 * 实现addToHead方法，将指定节点添加到链表头部。
 * 实现removeNode方法，将指定节点从链表中移除。
 * 实现removeTail方法，移除链表尾部的节点，并返回移除的节点。
 * 在测试方法中，创建LRUCache对象并进行一系列的插入和查询操作，验证LRU缓存的功能。
 * LRU缓存适用于需要高速缓存访问的场景，例如热门数据的缓存、数据库查询结果的缓存等。它通过保留最近访问的数据来提高缓存的命中率，从而加速数据访问速度。优势包括快速访问和自动淘汰，但需要注意存储开销和缓存命中率的问题。
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {
    private final int capacity;  // 缓存容量
    private final Map<K, Node> cache;  // 缓存键值对的映射
    private final Node head;  // 双向链表头节点
    private final Node tail;  // 双向链表尾节点

    private class Node {
        K key;  // 键
        V value;  // 值
        Node prev;  // 前一个节点
        Node next;  // 后一个节点

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;  // 初始化双向链表
        tail.prev = head;
    }

    public V get(K key) {
        Node node = cache.get(key);  // 获取缓存中的节点
        if (node != null) {
            moveToHead(node);  // 将节点移动到链表头部表示最近使用
            return node.value;  // 返回节点的值
        }
        return null;
    }

    public void put(K key, V value) {
        Node node = cache.get(key);  // 获取缓存中的节点
        if (node != null) {  // 如果节点已存在
            node.value = value;  // 更新节点的值
            moveToHead(node);  // 将节点移动到链表头部表示最近使用
        } else {  // 如果节点不存在
            node = new Node(key, value);  // 创建新节点
            cache.put(key, node);  // 将新节点放入缓存
            addToHead(node);  // 将节点添加到链表头部
            if (cache.size() > capacity) {  // 如果缓存已满
                Node removed = removeTail();  // 移除链表尾部的节点
                cache.remove(removed.key);  // 从缓存中移除对应的键值对
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);  // 从链表中移除节点
        addToHead(node);  // 将节点添加到链表头部
    }

    private void addToHead(Node node) {
        node.prev = head;  // 将节点的前一个指针指向头节点
        node.next = head.next;  // 将节点的后一个指针指向原来头节点的后一个节点
        head.next.prev = node;  // 将原来头节点的后一个节点的前一个指针指向节点
        head.next = node;  // 将头节点的后一个指针指向节点
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;  // 将节点的前一个节点的后一个指针指向节点的后一个节点
        node.next.prev = node.prev;  // 将节点的后一个节点的前一个指针指向节点的前一个节点
    }

    private Node removeTail() {
        Node removed = tail.prev;  // 获取尾节点的前一个节点
        removeNode(removed);  // 从链表中移除尾节点的前一个节点
        return removed;  // 返回移除的节点
    }

    // 测试方法
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "Value 1");
        cache.put(2, "Value 2");
        System.out.println(cache.get(1));  // 输出: Value 1

        cache.put(3, "Value 3");
        System.out.println(cache.get(2));  // 输出: null

        cache.put(4, "Value 4");
        System.out.println(cache.get(1));  // 输出: null
        System.out.println(cache.get(3));  // 输出: Value 3
        System.out.println(cache.get(4));  // 输出: Value 4
    }
}

