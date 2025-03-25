package Recursion.LinkedList;

public class DLL {
    public DLL() {

    }

    private Node head;

    public class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.print("LAST");
        System.out.println();
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.print("FIRST");
    }

    public static void main(String[] args) {
        DLL ll = new DLL();
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(4);
        ll.display();
    }
}
