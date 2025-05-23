package DP.zeroone;

public class EqualSum2 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] memo = new boolean[n + 1][sum / 2 + 1];

        return canSum(nums, sum / 2, n, memo);
    }

    public boolean canSum(int[] nums, int sum, int n, boolean[][] memo) {
        for (int i = 0; i <= n; i++) {
            memo[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            memo[0][j] = false;
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                if (nums[i - 1] <= j) {
                    memo[i][j] = memo[i - 1][j - nums[i - 1]] || memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }

            }
        }

        return memo[n][sum];

    }
}
