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

    public int deleteFirst() {
        int val = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        int val = tail.val;
        Node temp = get(size - 2);
        tail = temp;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
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
        ll.deleteFirst();
        ll.display();
        System.out.println(ll.deleteLast());
        ll.display();
        ll.delete(1);
        ll.display();

    }
}
