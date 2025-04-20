package SlidingWindow;

public class fixedsum {
    public static int maxSum(int[] arr, int n, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int windowsum = 0;
        while (j < n) {
            if (j - i < k) {
                sum += arr[j];
                j++;
            }
            if (j - i == k) {
                windowsum = sum + arr[j];
                if (windowsum > sum) {

                }

            }
            if (j - i > k) {
                sum -= arr[i];
                i++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}
