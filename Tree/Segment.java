package Tree;

public class Segment {
    public class Node {
        int val;
        int StartInterval;
        int EndInterval;
        Node left;
        Node right;

        Node() {

        }
    }

    Segment() {

    }

    Node root;

    public Node construct(int[] arr) {
        return root = construct(arr, 0, arr.length - 1);
    }

    public Node construct(int[] arr, int left, int right) {
        if (right == left) {
            Node node = new Node();
            node.val = arr[left];
            node.StartInterval = left;
            node.EndInterval = right;
            return node;
        }

        Node node = new Node();
        node.StartInterval = left;
        node.EndInterval = right;
        int m = (left + right) / 2;
        node.left = construct(arr, left, m);
        node.right = construct(arr, m + 1, right);
        node.val = node.left.val + node.right.val;
        return node;
    }

    public void display() {
        display(root);
    }

    public void display(Node node) {
        if (node == null) {
            return;
        }
        int val = node.val;
        int StartInterval = node.StartInterval;
        int EndInterval = node.EndInterval;
        System.out.println("Node val is " + val +
                " Start interval is " + StartInterval + " End Interval is " + EndInterval);
        display(node.left);
        display(node.right);

    }

    public int query(int qsi, int qei) {
        return query(root, qsi, qei);
    }

    public int query(Node node, int qsi, int qei) {
        if (qsi <= node.StartInterval && qei >= node.EndInterval) {
            return node.val;
        } else if (qei < node.StartInterval || qsi > node.EndInterval) {
            return 0;
        } else {
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }

    }

    public void update(int index, int val) {
        root = update(root, index, val);
    }

    public Node update(Node node, int index, int val) {
        if (index >= node.StartInterval && index <= node.EndInterval) {
            if (node.StartInterval == index && node.EndInterval == index) {
                node.val = val;
                return node;
            }
            node.left = update(node.left, index, val);
            node.right = update(node.right, index, val);
            node.val = node.left.val + node.right.val;
            return node;

        }
        return node;
    }

    public static void main(String[] args) {
        Segment seg = new Segment();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        seg.construct(arr);
        seg.display();
        seg.update(7, 0);
        seg.display();
        System.out.println(seg.query(3, 7));
    }
}
