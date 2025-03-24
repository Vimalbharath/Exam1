package Recursion.LinkedList;

public class linked {
    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    public void addFirst(int val) {
        Node node = new Node(val);
        size++;
        if (head == null) {
            tail = node;
        }
        node.next = head;
        head = node;
    }

    public void addLast(int val) {
        if (head == null) {
            addFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void addIndex(int val, int index) {
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addLast(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
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
        ll.addLast(4);
        ll.addIndex(100, 2);
        ll.display();

    }
}
