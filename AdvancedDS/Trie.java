package AdvancedDS;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public static class TrieNode {
        public TrieNode[] childNode;
        public int wordCount;
        private boolean isEndOfWord;

        public TrieNode() {
            childNode = new TrieNode[26];
            wordCount = 0;
            isEndOfWord = false; // Initialize isEndOfWord to false
        }
    }

    public void insert(String key) { // Modified to be a non-static method
        TrieNode currentNode = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (currentNode.childNode[index] == null) {
                currentNode.childNode[index] = new TrieNode();
            }
            currentNode = currentNode.childNode[index];
        }
        currentNode.wordCount++;
        currentNode.isEndOfWord = true; // Mark the end of the word
    }

    public boolean isPrefixExist(String key) { // Modified to be a non-static method
        TrieNode currentNode = root;

        for (char c : key.toCharArray()) {
            if (currentNode.childNode[c - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.childNode[c - 'a'];
        }
        return true;
    }

    public boolean search(String key) { // Modified to be a non-static method
        TrieNode currentNode = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                return false;
            }
            currentNode = currentNode.childNode[index];
        }
        return currentNode.isEndOfWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] keys = { "the", "a", "there", "answer", "any",
                "by", "bye", "their" };

        System.out.println("Keys to insert:");
        for (String key : keys) {
            System.out.print(key + " ");
            trie.insert(key);
        }
        System.out.println("\n");

        System.out.println("Search results:");
        System.out.println("the -> " + trie.search("the")); // true
        System.out.println("these -> " + trie.search("these")); // false
        System.out.println("their -> " + trie.search("their")); // true
        System.out.println("thaw -> " + trie.search("thaw")); // false
        System.out.println("a -> " + trie.search("a")); // true
        System.out.println("answer -> " + trie.search("answer")); // true
        System.out.println("an -> " + trie.search("an")); // false (as 'an' is a prefix, not a complete word in this
                                                          // trie)

        System.out.println("\nPrefix check:");
        System.out.println("th -> " + trie.isPrefixExist("th")); // true
        System.out.println("the -> " + trie.isPrefixExist("the")); // true
        System.out.println("these -> " + trie.isPrefixExist("these"));// true (as 'these' starts with 'the')
        System.out.println("ans -> " + trie.isPrefixExist("ans")); // true (as 'answer' starts with 'ans')
        System.out.println("by -> " + trie.isPrefixExist("by")); // true
        System.out.println("b -> " + trie.isPrefixExist("b")); // true
        System.out.println("ap -> " + trie.isPrefixExist("ap")); // false
    }
}