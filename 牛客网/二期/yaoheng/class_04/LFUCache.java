package 牛客网.二期.yaoheng.class_04;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache<K, V> {
    private final int capacity; // 缓存容量
    private final Map<K, Node> cache; // 缓存
    private final Map<Integer, LinkedHashSet<K>> frequencyMap; // 频率映射表
    private int minFrequency; // 最小频率

    private class Node { // 节点类
        K key; // 键
        V value; // 值
        int frequency; // 频率

        public Node(K key, V value, int frequency) { // 节点构造函数
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }

    public LFUCache(int capacity) { // 构造函数
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.minFrequency = 0;
    }

    public V get(K key) { // 获取缓存中的值
        Node node = cache.get(key);
        if (node != null) {
            updateFrequency(node); // 更新节点频率
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) { // 向缓存中存入值
        if (capacity == 0) {
            return;
        }

        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            updateFrequency(node); // 更新节点频率
        } else {
            if (cache.size() >= capacity) {
                evict(); // 淘汰缓存
            }
            Node newNode = new Node(key, value, 1);
            cache.put(key, newNode);
            addToFrequencyMap(newNode); // 添加到频率映射表
            minFrequency = 1;
        }
    }

    private void updateFrequency(Node node) { // 更新节点频率
        int frequency = node.frequency;
        LinkedHashSet<K> set = frequencyMap.get(frequency);
        set.remove(node.key);

        if (frequency == minFrequency && set.isEmpty()) {
            minFrequency++;
        }

        node.frequency++;
        LinkedHashSet<K> newSet = frequencyMap.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>());
        newSet.add(node.key);
    }

    private void evict() { // 淘汰缓存
        LinkedHashSet<K> set = frequencyMap.get(minFrequency);
        K keyToRemove = set.iterator().next();
        set.remove(keyToRemove);
        cache.remove(keyToRemove);
    }

    private void addToFrequencyMap(Node node) { // 添加到频率映射表
        LinkedHashSet<K> set = frequencyMap.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>());
        set.add(node.key);
    }

    public static void main(String[] args) { // 主函数
        LFUCache<Integer, String> cache = new LFUCache<>(3);
        cache.put(1, "Value 1"); // 存入键为1，值为"Value 1"的数据
        cache.put(2, "Value 2"); // 存入键为2，值为"Value 2"的数据
        cache.put(3, "Value 3"); // 存入键为3，值为"Value 3"的数据

        System.out.println(cache.get(1)); // 输出: Value 1
        System.out.println(cache.get(2)); // 输出: Value 2
        System.out.println(cache.get(3)); // 输出: Value 3

        cache.put(4, "Value 4"); // 存入键为4，值为"Value 4"的数据
        System.out.println(cache.get(1)); // 输出: null
        System.out.println(cache.get(2)); // 输出: Value 2
        System.out.println(cache.get(3)); // 输出: Value 3
        System.out.println(cache.get(4)); // 输出: Value 4
    }
}

