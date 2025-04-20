package SlidingWindow;

public class fixedsum {
    public static int maxSum(int[] arr, int n, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxsum = 0;
        while (j < n) {
            sum += arr[j];
            if (j - i + 1 < k) {

                j++;
            } else if (j - i + 1 == k) {

                if (maxsum < sum) {
                    maxsum = sum;
                }
                i++;
                j++;

            }
            if (j - i + 1 > k) {
                sum -= arr[i];
                i++;

            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}
