package AdvancedDS;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public class TrieNode {
        public TrieNode[] childNode;
        public int wordCount;
        private boolean isEndOfWord;

        public TrieNode() {
            childNode = new TrieNode[26];
            // This will keep track of number of strings that
            // are stored in the Trie from root node to any Trie
            // node.
            wordCount = 0;
        }
        // TrieNode root = new TrieNode();
    }

    static void insert(TrieNode root, String key) {
        // Initialize the currentNode pointer with the root node
        TrieNode currentNode = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            // Check if the node exist for the current
            // character in the Trie.
            if (currentNode.childNode[index] == null) {

                // Keep the reference for the newly created
                // node.
                currentNode.childNode[index] = new TrieNode();
            }

            // Now, move the current node pointer to the newly
            // created node.
            currentNode = currentNode.childNode[index];
        }

        // Increment the wordEndCount for the last currentNode
        // pointer this implies that there is a string ending at
        // currentNode.
        currentNode.wordCount++;
    }

    public boolean isPrefixExist(TrieNode root, String key) {
        // Initialize the currentNode pointer
        // with the root node
        TrieNode currentNode = root;

        // Iterate across the length of the string
        for (char c : key.toCharArray()) {

            // Check if the node exist for the current
            // character in the Trie.
            if (currentNode.childNode[c - 'a'] == null) {

                // Given word as a prefix does not exist in Trie
                return false;
            }

            // Move the currentNode pointer to the already
            // existing node for current character.
            currentNode = currentNode.childNode[c - 'a'];
        }

        // Prefix exist in the Trie
        return true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(TrieNode root, String key) {
        // Initialize the currentNode
        // with the root node
        TrieNode currentNode = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            // Check if the node exist for the current
            // character in the Trie.
            if (currentNode.childNode[index] == null)
                return false;

            // Move the currentNode to the already
            // existing node for current character.
            currentNode = currentNode.childNode[index];
        }

        return (currentNode.isEndOfWord);
    }

    public static void main(String[] args) {

    }

}
