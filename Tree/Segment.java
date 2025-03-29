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
        return root = construct(arr, 0, arr.length);
    }

    public Node construct(int[] arr, int left, int right) {
        if (arr.length == 1) {
            Node node = new Node();
            node.val = arr[left];
            node.StartInterval = left;
            node.EndInterval = right;
            return node;
        }

        Node node = new Node();
        node.StartInterval = left;
        node.EndInterval = right;
        int m = left + right / 2;
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
        System.out
                .println("Node val is" + val + "Start interval is " + StartInterval + "End Interval is " + EndInterval);
        display(node.left);
        display(node.right);

    }

    public static void main(String[] args) {
        Segment seg = new Segment();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        seg.construct(arr);
        seg.display();
    }
}
