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

}
