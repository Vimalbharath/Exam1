package DP.zeroone;

import java.util.Arrays;

public class EqualSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int[][] memo = new int[n][sum + 1];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }

        return canSum(nums, sum / 2, n - 1, memo);
    }

    public boolean canSum(int[] nums, int sum, int n, int[][] memo) {
        if (memo[n][sum] != -1) {
            return (memo[n][sum] == 1 ? true : false);
        }
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (canSum(nums, sum - nums[n], n - 1, memo)) {
            memo[n - 1][sum - nums[n]] = 1;
        } else {
            memo[n - 1][sum - nums[n]] = 0;
        }
        if (canSum(nums, sum, n - 1, memo)) {
            memo[n - 1][sum] = 1;
        } else {
            memo[n - 1][sum] = 0;
        }
        return canSum(nums, sum - nums[n], n - 1, memo) || canSum(nums, sum, n - 1, memo);
    }
}
