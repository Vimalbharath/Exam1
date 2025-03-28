package Tree;

public class AVL {
    public class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node() {
        }

    }

    Node root;

    public AVL() {

    }

    public int height(Node node) {
        return node.height;
    }

    public void insert(int val) {
        insert(root, val);
    }

    public Node insert(Node node, int val) {
        if (node == null) {
            Node temp = new Node();
            temp.val = val;
            return temp;
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        }

        if (val > node.val) {
            node.right = insert(node.right, val);

        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;

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
        AVL tree = new AVL();
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(11);
        tree.inOrder();
    }
}
