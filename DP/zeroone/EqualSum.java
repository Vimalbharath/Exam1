package DP.zeroone;

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
        return canSum(nums, sum / 2, n - 1);
    }

    public boolean canSum(int[] nums, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        return canSum(nums, sum - nums[n], n - 1) || canSum(nums, sum, n - 1);
    }
}
