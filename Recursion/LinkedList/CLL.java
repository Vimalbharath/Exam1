package Recursion.LinkedList;

public class CLL {
    public CLL() {

    }

    private Node head;
    private Node tail;

    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        }
        node.next = head;
        tail.next = node;
        tail = node;
    }

    public void display() {
        Node temp = head;
        if (temp != null) {
            do {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.print("HEAD");
        }
    }

    public int deleteFirst() {
        if (head == null) {
            return -1;
        }
        int val = head.val;
        tail.next = head.next;
        head = head.next;
        return val;

    }

    public static void main(String[] args) {
        CLL ll = new CLL();
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.display();
        ll.deleteFirst();
        ll.deleteFirst();
        ll.deleteFirst();
        ll.display();

    }

}
