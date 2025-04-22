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

    public boolean delete(String key) {
        return true;
    }

    public static void main(String[] args) {
        TrieGFG trie = new TrieGFG();
        trie.insert("vimal");
        trie.insert("vishnu");
        trie.insert("vignesh");
        trie.insert("ram");
        trie.insert("bharath");
        System.out.println(trie.search("bharath"));
        System.out.println(trie.search("hi"));

    }

}