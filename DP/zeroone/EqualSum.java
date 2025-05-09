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
        int[][] memo = new int[n + 1][sum / 2 + 1];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }

        return canSum(nums, sum / 2, n, memo);
    }

    public boolean canSum(int[] nums, int sum, int n, int[][] memo) {
        if (memo[n][sum] != -1) {
            return (memo[n][sum] == 1 ? true : false);
        }
        if (sum == 0) {
            memo[n][sum] = 1;
            return true;
        }
        if (n == 0) {
            memo[n][sum] = 0;
            return false;
        }

        boolean include = false;
        if (n > 0 && sum >= nums[n - 1]) {
            include = canSum(nums, sum - nums[n - 1], n - 1, memo);
        }

        boolean exclude = canSum(nums, sum, n - 1, memo);
        memo[n][sum] = (include || exclude) == true ? 1 : 0;
        return (include || exclude);
    }
}
