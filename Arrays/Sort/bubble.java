package Arrays.Sort;

import java.util.Arrays;

public class bubble {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 2, 0, 9, 8 };
		System.out.println(Arrays.toString(arr));
		bubblesort(arr);
		System.out.println(Arrays.toString(arr));

	}

	public static void bubblesort(int[] arr) {
		boolean swapped;
		for (int i = 0; i < arr.length; i++) {
			swapped = false;
			for (int j = 1; j < arr.length - i; j++) {

				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
					swapped = true;
				}

			}
			if (!swapped) {
				break;
			}

		}
	}

	public static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
}
