package StacksQueue;

public class CustomQueue {
    private int[] data;
    private int ptr = -1;
    private static final int DEFAULT_SIZE = 5;

    public CustomQueue(int size) {
        data = new int[size];
    }

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public boolean isFull() {
        if (ptr == data.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (ptr == -1) {
            return true;
        }
        return false;
    }

    public boolean offer(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        ptr++;
        data[ptr] = val;

        return true;
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = data[0];
        for (int i = 0; i < ptr; i++) {
            data[i] = data[i + 1];
        }
        ptr--;
        return val;
    }

    public static void main(String[] args) {
        CustomQueue qu = new CustomQueue();
        qu.offer(1);
        qu.offer(2);
        qu.offer(3);
        qu.offer(4);
        qu.offer(5);
        qu.offer(6);
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.poll());

    }
}
