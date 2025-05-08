package DP.zeroone;

public class SubsetSum {
    public static int perfectSum(int[] arr, int target) {
        return perfectSum(0, 0, arr, target);

    }

    public static int perfectSum(int count, int i, int[] arr, int target) {

        if (i == arr.length) {
            return 0;
        }

        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }
        count += perfectSum(count, i + 1, arr, target - arr[i]);
        count += perfectSum(count, i + 1, arr, target);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3 };
        int target = 6;
        System.out.println(perfectSum(arr, target));
    }
}
