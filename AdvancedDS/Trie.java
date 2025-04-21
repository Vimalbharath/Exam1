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
            isEndOfWord = false;
        }
    }

    public void insert(String key) {
        TrieNode currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                currentNode.childNode[index] = new TrieNode();
            }
            currentNode = currentNode.childNode[index];
        }
        currentNode.wordCount++;
        currentNode.isEndOfWord = true;
    }

    public boolean isPrefixExist(String key) {
        TrieNode currentNode = root;
        for (char c : key.toCharArray()) {
            if (currentNode.childNode[c - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.childNode[c - 'a'];
        }
        return true;
    }

    public boolean search(String key) {
        TrieNode currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                return false;
            }
            currentNode = currentNode.childNode[index];
        }
        return currentNode != null && currentNode.isEndOfWord;
    }

    public boolean deleteKey(String word) {
        return deleteHelper(root, word, 0);
    }

private boolean deleteHelper(TrieNode currentNode, String word, int index) {
    if (index == word.length()) {
        if (currentNode.wordCount > 0) {
            currentNode.wordCount--;
            currentNode.isEndOfWord = false; // Unmark as end of word
            return hasNoChildren(currentNode) && currentNode.wordCount == 0;
        }
        return false; // Word not found
    }

    int charIndex = word.charAt(index) - 'a';
    if (currentNode.childNode[charIndex] == null) {
        return false; // Word not found
    }

    boolean shouldDeleteChild = deleteHelper(currentNode.childNode[charIndex], word, index + 1);

    if (shouldDeleteChild) {
        currentNode.childNode[charIndex] = null;
        return currentNode.wordCount == 0 && hasNoChildren(currentNode);
    }

    return false;
}

    private boolean hasNoChildren(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.childNode[i] != null) {
                return false;
            }
        }
        return true;
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
        System.out.println("the -> " + trie.search("the"));
        System.out.println("there -> " + trie.search("there"));
        System.out.println("their -> " + trie.search("their"));
        System.out.println("by -> " + trie.search("by"));
        System.out.println("bye -> " + trie.search("bye"));
        System.out.println("a -> " + trie.search("a"));
        System.out.println("answer -> " + trie.search("answer"));
        System.out.println("any -> " + trie.search("any"));
        System.out.println("an -> " + trie.search("an"));

        System.out.println("\nPrefix check:");
        System.out.println("th -> " + trie.isPrefixExist("th"));
        System.out.println("the -> " + trie.isPrefixExist("the"));
        System.out.println("these -> " + trie.isPrefixExist("these"));
        System.out.println("ans -> " + trie.isPrefixExist("ans"));
        System.out.println("by -> " + trie.isPrefixExist("by"));
        System.out.println("b -> " + trie.isPrefixExist("b"));
        System.out.println("ap -> " + trie.isPrefixExist("ap"));

        System.out.println("\nDeletion tests:");
        System.out.println("\nDeleting key: there");
        trie.deleteKey("there");
        System.out.println("Search 'there' after deletion: " + trie.search("there"));
        System.out.println("Prefix 'the' after deleting 'there': " + trie.isPrefixExist("the"));

        System.out.println("\nDeleting key: the");
        trie.deleteKey("the");
        System.out.println("Search 'the' after deletion: " + trie.search("the"));
        System.out.println("Prefix 'th' after deleting 'the': " + trie.isPrefixExist("th"));

        System.out.println("\nDeleting key: a");
        trie.deleteKey("a");
        System.out.println("Search 'a' after deletion: " + trie.search("a"));
        System.out.println("Prefix 'a' after deleting 'a': " + trie.isPrefixExist("a"));

        System.out.println("\nDeleting key: answer");
        trie.deleteKey("answer");
        System.out.println("Search 'answer' after deletion: " + trie.search("answer"));
        System.out.println("Prefix 'ans' after deleting 'answer': " + trie.isPrefixExist("ans"));
    }
}