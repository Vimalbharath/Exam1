package Recursion.Sort;

import java.util.Arrays;

public class selection {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 9, 7, 6, 2, 1 };
        System.out.println(Arrays.toString(arr));
        selectionsort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionsort(int[] arr, int row, int col, int max) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            if (arr[col] > arr[max]) {
                selectionsort(arr, row, col + 1, col);

            } else {

                selectionsort(arr, row, col + 1, max);

            }
        } else {
            int temp = arr[max];
            arr[max] = arr[row - 1];
            arr[row - 1] = temp;
            selectionsort(arr, row - 1, 0, 0);
        }

    }
}
