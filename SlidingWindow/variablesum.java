package SlidingWindow;

public class variablesum {

    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int res = 0;
        int maxres = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < n) {
            if (sum < k) {
                sum += arr[j];
                j++;
            }
            if (sum == k) {
                res = j - i + 1;
                if (res > maxres) {
                    maxres = res;
                }
                j++;
            }
            if (sum > k) {
                sum -= arr[i];
                i++;
            }
        }
        return maxres;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }
}
