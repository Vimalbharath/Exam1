package Recursion.Sort;

import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 9, 7, 6, 2, 1 };
        System.out.println(Arrays.toString(arr));
        bubblesort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubblesort(int[] arr, int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            if (arr[col + 1] < arr[col]) {
                int temp = arr[col + 1];
                arr[col + 1] = arr[col];
                arr[col] = temp;
            }

            bubblesort(arr, row, col + 1);

        } else {

            bubblesort(arr, row - 1, 0);

        }
    }
}
