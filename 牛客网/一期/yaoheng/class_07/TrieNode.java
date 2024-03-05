package 牛客网.一期.yaoheng.class_07;

// Trie树节点类
class TrieNode {
    private TrieNode[] children; // 子节点数组
    private boolean isWord; // 标记当前节点是否为单词的结尾

    public TrieNode() {
        children = new TrieNode[26]; // 假设只包含小写字母，初始化子节点数组
        isWord = false; // 初始化isWord为false
    }

    // 插入一个单词到Trie树
    public void insert(String word) {
        TrieNode node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // 计算字符在子节点数组中的索引
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // 如果子节点不存在，则创建一个新的节点
            }
            node = node.children[index]; // 移动到下一个节点
        }
        node.isWord = true; // 标记单词的结尾节点
    }

    // 搜索一个单词是否存在于Trie树中
    public boolean search(String word) {
        TrieNode node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // 计算字符在子节点数组中的索引
            if (node.children[index] == null) {
                return false; // 如果子节点不存在，单词不存在于Trie树中
            }
            node = node.children[index]; // 移动到下一个节点
        }
        return node.isWord; // 判断是否为单词的结尾节点
    }

    // 判断一个前缀是否存在于Trie树中
    public boolean startsWith(String prefix) {
        TrieNode node = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a'; // 计算字符在子节点数组中的索引
            if (node.children[index] == null) {
                return false; // 如果子节点不存在，前缀不存在于Trie树中
            }
            node = node.children[index]; // 移动到下一个节点
        }
        return true; // 前缀存在于Trie树中
    }

    // Trie树类
     static class Trie {
        private TrieNode root; // 根节点

        public Trie() {
            root = new TrieNode(); // 初始化根节点
        }

        // 插入一个单词到Trie树
        public void insert(String word) {
            root.insert(word);
        }

        // 搜索一个单词是否存在于Trie树中
        public boolean search(String word) {
            return root.search(word);
        }

        // 判断一个前缀是否存在于Trie树中
        public boolean startsWith(String prefix) {
            return root.startsWith(prefix);
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        // 插入单词
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");

        // 搜索单词
        System.out.println(trie.search("apple"));   // 输出 true
        System.out.println(trie.search("banana"));  // 输出 true
        System.out.println(trie.search("orange"));  // 输出 true
        System.out.println(trie.search("grape"));   // 输出 false

        // 搜索前缀
        System.out.println(trie.startsWith("app"));   // 输出 true
        System.out.println(trie.startsWith("ban"));   // 输出 true
        System.out.println(trie.startsWith("or"));    // 输出 true
        System.out.println(trie.startsWith("gr"));    // 输出 false
    }
}

