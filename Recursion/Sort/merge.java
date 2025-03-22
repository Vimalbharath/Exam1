package Recursion.Sort;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 9, 7, 6, 2, 1 };
        System.out.println(Arrays.toString(arr));
        int[] result = mergesort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergesort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int s = 0;
        int e = arr.length;
        int m = s + (e - s) / 2;
        int[] first = mergesort(Arrays.copyOfRange(arr, s, m));
        int[] second = mergesort(Arrays.copyOfRange(arr, m, e));
        return combined(first, second);
    }

    public static int[] combined(int[] first, int[] second) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] mix = new int[first.length + second.length];
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

}
