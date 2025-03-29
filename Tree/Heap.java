package Tree;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    public ArrayList<T> list;

    public int parent(int index) {
        return index - 1 / 2;
    }

    public int left(int index) {
        return (index * 2) + 1;
    }

    public int right(int index) {
        return (index * 2) + 2;
    }

    public void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public void insert(T val) {
        list.add(val);

        upheap(list.size() - 1);

    }

    public void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception(" List empty");
        }
        T temp = list.get(0);
        if (!list.isEmpty()) {
            list.set(0, list.remove(list.size() - 1));
            downheap(0);
        }
        return temp;
    }

    public void downheap(int index) {
        if (index > list.size()) {
            return;
        }
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(index).compareTo(list.get(left)) > 0) {
            swap(index, left);
            downheap(left);
        }

        if (right < list.size() && list.get(index).compareTo(list.get(right)) > 0) {
            swap(index, right);
            downheap(right);
        }

    }

    public ArrayList<T> heapsort() {
        ArrayList<T> data = new ArrayList<T>();
        while (!list.isEmpty()) {
            data.add(list.remove(0));
        }
        return data;
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);
        System.out.println(heap.heapsort());
    }
}
