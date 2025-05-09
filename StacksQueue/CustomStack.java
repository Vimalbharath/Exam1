package StacksQueue;

public class CustomStack {
    int[] data;
    int ptr = -1;
    public static final int DEFAULT_SIZE = 5;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        data = new int[size];
    }

    public boolean push(int val) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = val;

        return true;

    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return data[ptr--];
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

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
