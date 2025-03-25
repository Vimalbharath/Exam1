package Tree;

public class BST {
    public class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;

    public BST() {

    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    public Node insert(int val) {
        return root = insert(root, val);
    }

    public Node insert(Node node, int val) {
        if (node == null) {
            return node;
        }
        if (val < node.val) {
            Node left = insert(node.left, val);
        }
        if (val > node.val) {
            Node right = insert(node.right, val);
        }
        node.height = Math.min(height(node.left), height(node.right));
        return node;
    }

    public int height(Node node) {
        return node.height;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(11);
        tree.inOrder();
    }

}
