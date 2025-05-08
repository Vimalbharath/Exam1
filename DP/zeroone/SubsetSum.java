package DP.zeroone;

//https://leetcode.com/problems/partition-equal-subset-sum/description/

public class SubsetSum {
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
        System.out.println(perfectSum(arr, target));
    }
}
