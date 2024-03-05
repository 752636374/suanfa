package 牛客网.二期.yaoheng.class_02;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache_yh<K, V> {
    LinkedNode<K, V> linkedNode;
    Map<K, Node<K, V>> map;
    int capacity;

    public LeastRecentlyUsedCache_yh(int length) {
        linkedNode = new LinkedNode<>();
        map = new HashMap<>();
        capacity = length;
    }

    public void addNode(K key, V value) {
        //添加到map
        if (map.containsKey(key)) {
            //更新值
            Node<K, V> node = map.get(key);
            node.value = value;
            //添加到头部
            linkedNode.removeToHead(node);
        } else {
            //添加到双向链表，链表满，链表
            if (map.size() >= capacity) {
                Node<K, V> node = linkedNode.removeTail();
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            linkedNode.addToHead(node);
        }
    }


    public V getNode(K key) {
        //存在则移动到首部
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            linkedNode.removeToHead(node);
            return node.value;
        }
        return null;
    }


    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LinkedNode<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public LinkedNode() {
        }

        public void add(Node<K, V> node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        public void removeToHead(Node node) {
            //在头部
            if (head == node) {
                return;
            }
            if (tail == node) {//在尾部
                tail = tail.pre;
                node.pre.next = null;
            } else {//在中部
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.next = head;
            node.pre = null;
            head.pre = node;
            head = node;
        }

        public Node<K, V> removeTail() {
            if (tail == null) {
                return null;
            }
            Node node = tail;
            tail = tail.pre;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            return node;
        }

        public void addToHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }
    }

    public static void main(String[] args) {
        //创建节点
        LeastRecentlyUsedCache_yh l = new LeastRecentlyUsedCache_yh(3);
        l.addNode(1, "one");
        l.addNode(2, "two");
        l.addNode(3, "three");
        System.out.println(l.getNode(1));
        System.out.println(l.getNode(2));
        System.out.println(l.getNode(3));
        //添加数据
        l.addNode(4, "four");
        l.addNode(5, "five");
        l.addNode(6, "six");
        System.out.println(l.getNode(1));
        System.out.println(l.getNode(4));
        System.out.println(l.getNode(5));
        System.out.println(l.getNode(6));


    }
}
