package Arrays.Sort;

import java.util.Arrays;

public class selection {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 1, 2, 0, 9, 8 };
        System.out.println(Arrays.toString(arr));
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1 - i;
            int max = maxindex(arr, 0, last);
            swap(arr, max, last);
        }
    }

    public static int maxindex(int[] arr, int first, int last) {
        int max = first;
        for (int i = 0; i <= last; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
