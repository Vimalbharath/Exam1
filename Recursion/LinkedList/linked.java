package Recursion.LinkedList;

public class linked {
    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    public void addFirst(int val) {
        Node node = new Node(val);
        size++;
        if (head == null) {
            head = tail = node;
        }
        node.next = head;
        head = node;
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        linked ll = new linked();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.display();
    }
}
