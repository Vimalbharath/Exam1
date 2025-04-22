package AdvancedDS;

public class TrieGFG {
    public class TrieNode {
        TrieNode[] childNode;
        int wordCount;

        TrieNode() {
            childNode = new TrieNode[26];
            wordCount = 0;
        }
    }

    TrieNode root;

    TrieGFG() {
        this.root = new TrieNode();
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
        return currentNode.wordCount > 0;
    }

    public boolean deleteKey(String key) {
        TrieNode currentNode = root;
        TrieNode lastBranchNode = null;
        char lastBranchCharacter = 'a';
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                return false;
            } else {
                int count = 0;
                for (int j = 0; j < 26; j++) {
                    if (currentNode.childNode[j] != null) {
                        count++;
                    }
                }
                if (count > 1) {
                    lastBranchNode = currentNode;
                    lastBranchCharacter = key.charAt(i);
                }
            }
            currentNode = currentNode.childNode[index];
        }

        int count = 0;
        for (int j = 0; j < 26; j++) {
            if (currentNode.childNode[j] != null) {
                count++;
            }
        }
        if (count > 1) {
            currentNode.wordCount--;
        }

        if (lastBranchNode != null) {
            lastBranchNode.childNode[lastBranchCharacter - 'a'] = null;
            return true;
        } else {
            root.childNode[key.charAt(0) - 'a'] = null;
            return true;
        }

    }

    public static void main(String[] args) {
        TrieGFG trie = new TrieGFG();
        String[] keys = { "the", "a", "there", "answer", "any",
                "by", "bye", "their" };

        System.out.println("Keys to insert:");
        for (String key : keys) {
            System.out.print(key + " ");
            trie.insert(key); // Insert each key into the Trie
        }
        System.out.println("\n");

        System.out.println("Search results:");
        System.out.println("the -> " + trie.search("the")); // Search for "the"
        System.out.println("there -> " + trie.search("there")); // Search for "there"
        System.out.println("their -> " + trie.search("their")); // Search for "their"
        System.out.println("by -> " + trie.search("by")); // Search for "by"
        System.out.println("bye -> " + trie.search("bye")); // Search for "bye"
        System.out.println("a -> " + trie.search("a")); // Search for "a"
        System.out.println("answer -> " + trie.search("answer")); // Search for "answer"
        System.out.println("any -> " + trie.search("any")); // Search for "any"
        System.out.println("an -> " + trie.search("an")); // Search for "an" (prefix)

        // System.out.println("\nPrefix check:");
        // System.out.println("th -> " + trie.isPrefixExist("th")); // Check if "th" is
        // a prefix
        // System.out.println("the -> " + trie.isPrefixExist("the")); // Check if "the"
        // is a prefix
        // System.out.println("these -> " + trie.isPrefixExist("these"));// Check if
        // "these" is a prefix
        // System.out.println("ans -> " + trie.isPrefixExist("ans")); // Check if "ans"
        // is a prefix
        // System.out.println("by -> " + trie.isPrefixExist("by")); // Check if "by" is
        // a prefix
        // System.out.println("b -> " + trie.isPrefixExist("b")); // Check if "b" is a
        // prefix
        // System.out.println("ap -> " + trie.isPrefixExist("ap")); // Check if "ap" is
        // a prefix

        System.out.println("\nDeletion tests:");
        System.out.println("\nDeleting key: there");
        trie.deleteKey("there"); // Delete "there"
        System.out.println("Search 'there' after deletion: " + trie.search("there")); // Should be false
        // System.out.println("Prefix 'the' after deleting 'there': " +
        // trie.isPrefixExist("the")); // Should be true

        System.out.println("\nDeleting key: the");
        trie.deleteKey("the"); // Delete "the"
        System.out.println("Search 'the' after deletion: " + trie.search("the")); // Should be false
        // System.out.println("Prefix 'th' after deleting 'the': " +
        // trie.isPrefixExist("th")); // Should be true

        System.out.println("\nDeleting key: a");
        trie.deleteKey("a"); // Delete "a"
        System.out.println("Search 'a' after deletion: " + trie.search("a")); // Should be false
        // System.out.println("Prefix 'a' after deleting 'a': " +
        // trie.isPrefixExist("a")); // Should be false

        System.out.println("\nDeleting key: answer");
        trie.deleteKey("answer"); // Delete "answer"
        System.out.println("Search 'answer' after deletion: " + trie.search("answer")); // Should be false
        // System.out.println("Prefix 'ans' after deleting 'answer': " +
        // trie.isPrefixExist("ans")); // Should be true
    }
}