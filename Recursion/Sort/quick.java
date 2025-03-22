package Recursion.Sort;

import java.util.Arrays;

public class quick {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 9, 7, 6, 2, 1 };
        System.out.println(Arrays.toString(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (arr.length == 1) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = arr[m];
        while (s > e) {
            if (arr[s] < pivot) {
                s++;
            }
            if (arr[e] > pivot) {
                e--;
            }
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
        }
        quicksort(arr, low, e);
        quicksort(arr, s, high);

    }
}
