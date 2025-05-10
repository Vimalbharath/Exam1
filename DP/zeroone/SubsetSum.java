package DP.zeroone;

//https://leetcode.com/problems/partition-equal-subset-sum/description/

public class SubsetSum {
    public static int perfectSum2(int[] arr, int target) {
        int[][] memo = new int[arr.length + 1][target + 1];
        // for (int i = 0; i <= target; i++) {
        // memo[0][i] = 0;
        // }
        for (int i = 0; i <= arr.length; i++) {
            memo[0][i] = 1;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    memo[i][j] = memo[i - 1][j - arr[i]];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        return memo[arr.length][target];

    }

    public static int perfectSum(int[] arr, int target) {
        return perfectSum(target, 0, arr, target);

    }

    public static int perfectSum(int currsum, int i, int[] arr, int target) {

        if (currsum == 0) {
            return 1;
        }
        if (i == arr.length) {
            return 0;
        }

        if (currsum < 0) {
            return 0;
        }
        int left = perfectSum(currsum - arr[i], i + 1, arr, target);
        int right = perfectSum(currsum, i + 1, arr, target);
        return left + right;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3 };
        int target = 6;
        System.out.println(perfectSum2(arr, target));
    }
}
