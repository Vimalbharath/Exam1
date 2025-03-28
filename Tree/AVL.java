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

    public int value(Node node) {
        return node.val;

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int val) {
        root = insert(root, val);
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
        return rotate(node);

    }

    public Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right case

                return leftRotate(node);
            }
        }
        return node;
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        p.left = t;
        c.right = p;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
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

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            System.out.println("Left Child of Node " + value(node) + " is : " + value(node.left));
        }
        if (node.right != null) {
            System.out.println("Right Child of Node " + value(node) + " is : " + value(node.right));
        }
        display(node.left);
        display(node.right);

    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(2);
        tree.insert(22);
        tree.insert(100);
        tree.inOrder();
        tree.display();
    }
}
