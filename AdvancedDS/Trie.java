package AdvancedDS;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public static class TrieNode {
        public TrieNode[] childNode; // Array to store references to child nodes (for 26 lowercase English letters)
        public int wordCount; // Count of words ending at this node
        private boolean isEndOfWord; // Flag to indicate if a complete word ends at this node

        public TrieNode() {
            childNode = new TrieNode[26];
            wordCount = 0;
            isEndOfWord = false; // Initialize isEndOfWord to false
        }
    }

    // Inserts a key (word) into the Trie
    public void insert(String key) {
        TrieNode currentNode = root; // Start from the root

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a'; // Calculate the index (0-25) for the character

            // If the node for the current character doesn't exist, create a new one
            if (currentNode.childNode[index] == null) {
                currentNode.childNode[index] = new TrieNode();
            }
            // Move to the child node for the current character
            currentNode = currentNode.childNode[index];
        }
        // After processing all characters, mark the last node as the end of a word
        currentNode.wordCount++;
        currentNode.isEndOfWord = true;
    }

    // Checks if a given key (prefix) exists in the Trie
    public boolean isPrefixExist(String key) {
        TrieNode currentNode = root; // Start from the root

        for (char c : key.toCharArray()) {
            int index = c - 'a'; // Calculate the index for the character

            // If the node for the current character doesn't exist, the prefix doesn't exist
            if (currentNode.childNode[index] == null) {
                return false;
            }
            // Move to the child node for the current character
            currentNode = currentNode.childNode[index];
        }
        // If we reached the end of the key, the prefix exists
        return true;
    }

    // Searches for a given key (word) in the Trie
    public boolean search(String key) {
        TrieNode currentNode = root; // Start from the root

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a'; // Calculate the index for the character

            // If the node for the current character doesn't exist, the word doesn't exist
            if (currentNode.childNode[index] == null) {
                return false;
            }
            // Move to the child node for the current character
            currentNode = currentNode.childNode[index];
        }
        // Return true if we reached the end of the key and the last node marks the end
        // of a word
        return currentNode != null && currentNode.isEndOfWord;
    }

    // Deletes a key (word) from the Trie
    public boolean deleteKey(String word) {
        return deleteHelper(root, word, 0);
    }

    // Recursive helper function for deleting a key
    private boolean deleteHelper(TrieNode currentNode, String word, int index) {
        // Base case: Reached the end of the word
        if (index == word.length()) {
            // If the current node marks the end of a word
            if (currentNode.wordCount > 0) {
                currentNode.wordCount--; // Decrement the word count
                currentNode.isEndOfWord = false; // Unmark as end of word
                // Return true if this node has no children and its word count is now 0
                // This indicates that the parent might need to consider deletion
                return hasNoChildren(currentNode) && currentNode.wordCount == 0;
            }
            return false; // Word not found
        }

        int charIndex = word.charAt(index) - 'a'; // Calculate the index for the current character
        // If the child node for the current character doesn't exist, the word is not in
        // the Trie
        if (currentNode.childNode[charIndex] == null) {
            return false; // Word not found
        }

        // Recursively call deleteHelper for the child node and the next character
        boolean shouldDeleteChild = deleteHelper(currentNode.childNode[charIndex], word, index + 1);

        // If the recursive call returned true (indicating the child node might be
        // deleted)
        if (shouldDeleteChild) {
            // Only delete the child if the current node doesn't mark another word
            if (currentNode.wordCount == 0) {
                int nonNullChildren = 0;
                for (int i = 0; i < 26; i++) {
                    if (currentNode.childNode[i] != null) {
                        nonNullChildren++;
                    }
                }
                // If only the child we are considering for deletion exists, delete it
                if (nonNullChildren <= 1) {
                    currentNode.childNode[charIndex] = null;
                    return true; // Current node might also be a candidate for deletion
                } else {
                    return false; // Has other children, so don't delete
                }
            } else {
                return false; // Current node marks a word, don't delete its children
            }
        }

        // If no deletion happened down the path, return false
        return false;
    }

    // Helper function to check if a TrieNode has no children
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

        System.out.println("\nPrefix check:");
        System.out.println("th -> " + trie.isPrefixExist("th")); // Check if "th" is a prefix
        System.out.println("the -> " + trie.isPrefixExist("the")); // Check if "the" is a prefix
        System.out.println("these -> " + trie.isPrefixExist("these"));// Check if "these" is a prefix
        System.out.println("ans -> " + trie.isPrefixExist("ans")); // Check if "ans" is a prefix
        System.out.println("by -> " + trie.isPrefixExist("by")); // Check if "by" is a prefix
        System.out.println("b -> " + trie.isPrefixExist("b")); // Check if "b" is a prefix
        System.out.println("ap -> " + trie.isPrefixExist("ap")); // Check if "ap" is a prefix

        System.out.println("\nDeletion tests:");
        System.out.println("\nDeleting key: there");
        trie.deleteKey("there"); // Delete "there"
        System.out.println("Search 'there' after deletion: " + trie.search("there")); // Should be false
        System.out.println("Prefix 'the' after deleting 'there': " + trie.isPrefixExist("the")); // Should be true

        System.out.println("\nDeleting key: the");
        trie.deleteKey("the"); // Delete "the"
        System.out.println("Search 'the' after deletion: " + trie.search("the")); // Should be false
        System.out.println("Prefix 'th' after deleting 'the': " + trie.isPrefixExist("th")); // Should be true

        System.out.println("\nDeleting key: a");
        trie.deleteKey("a"); // Delete "a"
        System.out.println("Search 'a' after deletion: " + trie.search("a")); // Should be false
        System.out.println("Prefix 'a' after deleting 'a': " + trie.isPrefixExist("a")); // Should be false

        System.out.println("\nDeleting key: answer");
        trie.deleteKey("answer"); // Delete "answer"
        System.out.println("Search 'answer' after deletion: " + trie.search("answer")); // Should be false
        System.out.println("Prefix 'ans' after deleting 'answer': " + trie.isPrefixExist("ans")); // Should be true
    }
}