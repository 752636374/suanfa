package 牛客网.一期.yaoheng.class_07;


public class TrieNode_yh {
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }

        public void insert(String word) {
            TrieNode treeNode = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (treeNode.children[index] == null) {
                    treeNode.children[index] = new TrieNode();
                }
                treeNode = treeNode.children[index];
            }
            treeNode.isWord = true;
        }

        public boolean serach(String word) {
            TrieNode treeNode = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (treeNode.children[index] == null) {
                  return false;
                }
                treeNode = treeNode.children[index];
            }
            return treeNode.isWord;

        }

        public boolean startWith(String word) {
            TrieNode treeNode = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (treeNode.children[index] == null) {
                    return false;
                }
                treeNode = treeNode.children[index];
            }
           return true;
        }
    }

    static class Trie {
        TrieNode trieNode;

        public Trie(){
            trieNode = new TrieNode();
        }

        public void insert(String abc) {
            trieNode.insert(abc);
        }

        public boolean search(String aaa) {
            return trieNode.serach(aaa);
        }

        public boolean startWith(String aaa) {
            return trieNode.startWith(aaa);
        }
    }

    public static void main(String[] args) {
        //新增数据
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("bcde");
        trie.insert("efg");
        //查找数据
        System.out.println(trie.search("aaa"));
        System.out.println(trie.search("ab"));
        System.out.println(trie.search("de"));


        //查找数据
        System.out.println(trie.startWith("aaa"));
        System.out.println(trie.startWith("abc"));
        System.out.println(trie.startWith("abcefg"));
    }
}
