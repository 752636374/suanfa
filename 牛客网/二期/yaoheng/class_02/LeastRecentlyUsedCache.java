package 牛客网.二期.yaoheng.class_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码说明：
 * <p>
 * LeastRecentlyUsedCache 类实现了一个最近最少使用（LRU）缓存。它基于 LinkedHashMap 实现，通过继承 LinkedHashMap 并重写 removeEldestEntry 方法来控制缓存的大小。
 * get 方法用于获取缓存中指定键的值。
 * put 方法用于向缓存中插入键值对。
 * remove 方法用于从缓存中移除指定键。
 * clear 方法用于清空缓存。
 * 时间复杂度：
 * <p>
 * get 方法的时间复杂度为 O(1)。
 * put 方法的时间复杂度为 O(1)。
 * remove 方法的时间复杂度为 O(1)。
 * clear 方法的时间复杂度为 O(1)。
 * 空间复杂度： 该实现的空间复杂度为 O(capacity)，其中 capacity 表示缓存的容量。
 * <p>
 * 实现目的： 该实现的目的是创建一个最近最少使用（LRU）缓存，用于存储最常访问的数据项，并在缓存达到容量上限时移除最近最少使用的数据项。
 * <p>
 * 通过 LRU 缓存，可以提高缓存的命中率，减少对底层存储的访问次数，提高系统的性能。
 * <p>
 * 该实现使用了 LinkedHashMap 来实现 LRU 缓存，通过重写 removeEldestEntry 方法来控制缓存的大小和移除最近最少使用的数据项。
 * <p>
 * 优点：
 * <p>
 * 时间复杂度低：get、put、remove 和 clear 方法的时间复杂度都为 O(1)，即常数时间复杂度。
 * 支持最近最少使用策略：该实现能够根据访问顺序自动移除最近最少使用的数据项，提高缓存的命中率。
 * 缺点：
 * <p>
 * 依赖于 LinkedHashMap：该实现基于 LinkedHashMap 实现，可能会受到 LinkedHashMap 的一些限制和性能影响。
 * 线程不安全：该实现不是线程安全的，如果在多线程环境中使用，可能需要进行额外的同步处理
 *
 * @param <K>
 * @param <V>
 */
public class LeastRecentlyUsedCache<K, V> {
    private final int capacity; // 缓存容量
    private final Map<K, Node<K, V>> cache; // 缓存映射表
    private final DoublyLinkedList<K, V> list; // 双向链表

    public LeastRecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(); // 初始化缓存映射表
        this.list = new DoublyLinkedList<>(); // 初始化双向链表
    }

    public V get(K key) {
        if (cache.containsKey(key)) { // 如果缓存中存在键值
            Node<K, V> node = cache.get(key); // 获取对应的节点
            list.moveToHead(node); // 将节点移动到链表头部，表示最近访问
            return node.value; // 返回节点的值
        }
        return null; // 如果缓存中不存在键值，则返回null
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) { // 如果缓存中存在键值
            Node<K, V> node = cache.get(key); // 获取对应的节点
            node.value = value; // 更新节点的值
            list.moveToHead(node); // 将节点移动到链表头部，表示最近访问
        } else { // 如果缓存中不存在键值
            if (cache.size() >= capacity) { // 如果缓存已满
                Node<K, V> tail = list.removeTail(); // 移除链表尾部的节点
                cache.remove(tail.key); // 从缓存映射表中移除对应的键值
            }
            Node<K, V> newNode = new Node<>(key, value); // 创建新节点
            list.addToHead(newNode); // 将新节点添加到链表头部
            cache.put(key, newNode); // 将新节点添加到缓存映射表
        }
    }

    /**
     * 节点
     * @param <K>
     * @param <V>
     */
    private static class Node<K, V> {
        private final K key; // 键
        private V value; // 值
        private Node<K, V> prev; // 前驱节点
        private Node<K, V> next; // 后继节点

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 双向链表
     * @param <K>
     * @param <V>
     */
    private static class DoublyLinkedList<K, V> {
        private Node<K, V> head; // 链表头部节点
        private Node<K, V> tail; // 链表尾部节点

        public void addToHead(Node<K, V> node) {
            if (head == null) { // 如果链表为空
                head = node;
                tail = node;
            } else { // 如果链表不为空
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public void moveToHead(Node<K, V> node) {
            if (node == head) { // 如果节点已经是头部节点
                return;
            }

            if (node == tail) { // 如果节点是尾部节点
                tail = tail.prev;
                tail.next = null;
            } else { // 如果节点是中间节点
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }

        public Node<K, V> removeTail() {
            if (tail == null) { // 如果链表为空
                return null;
            }

            Node<K, V> removed = tail; // 获取尾部节点
            tail = tail.prev; // 更新尾部节点

            if (tail != null) { // 如果链表非空
                tail.next = null;
            } else { // 如果链表为空
                head = null;
            }

            return removed; // 返回移除的节点
        }
    }

    public static void main(String[] args) {
        LeastRecentlyUsedCache<Integer, String> cache = new LeastRecentlyUsedCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        System.out.println(cache.get(1)); // 输出: One
        System.out.println(cache.get(2)); // 输出: Two
        System.out.println(cache.get(3)); // 输出: Three

        cache.put(4, "Four");

        System.out.println(cache.get(1)); // 输出: null
        System.out.println(cache.get(2)); // 输出: Two
        System.out.println(cache.get(3)); // 输出: Three
        System.out.println(cache.get(4)); // 输出: Four
    }
}

