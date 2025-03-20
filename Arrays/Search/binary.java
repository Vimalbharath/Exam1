package Arrays.Search;

public class binary {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 6, 7, 8 };
		int result = binarysearch(arr, 5);
		System.out.println(result);

	}

	public static int binarysearch(int[] arr, int target) {
		int s = 0;
		int e = arr.length - 1;
		while (s <= e) {
			int m = s + (e - s) / 2;
			if (arr[m] < target) {
				s = m + 1;
			} else if (arr[m] > target) {
				e = m;
			} else {
				return m;
			}

		}
		return -1;
	}
}
