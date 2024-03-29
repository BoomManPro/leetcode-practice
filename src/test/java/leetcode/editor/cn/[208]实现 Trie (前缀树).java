package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest208 {
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                TrieNode next = node.get(ch);
                if (next == null) {
                    next = new TrieNode();
                    node.put(ch, next);
                }
                node = next;
            }
            node.setIsEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                TrieNode next = node.get(ch);
                if ( next== null) {
                    return false;
                }
                node = next;
            }
            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                char ch = prefix.charAt(i);
                TrieNode next = node.get(ch);
                if ( next== null) {
                    return false;
                }
                node = next;
            }
            return true;
        }
        static class TrieNode {
            private TrieNode[] links;

            private final int R = 26;

            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setIsEnd() {
                this.isEnd = true;
            }
        }
    }



    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Trie trie = new Trie();
            trie.insert("apple");
            Assert.assertTrue(trie.search("apple")); // 返回 true
            Assert.assertFalse(trie.search("app"));     // 返回 false
            Assert.assertTrue(trie.startsWith("app")); // 返回 true
            trie.insert("app");
            Assert.assertTrue(trie.search("app")); // 返回 true
        }
    }
}