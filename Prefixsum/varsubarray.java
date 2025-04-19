package Prefixsum;

//https://leetcode.com/problems/sum-of-variable-length-subarrays/description/?envType=problem-list-v2&envId=prefix-sum

public class varsubarray {
    public int subarraySum1(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int j = i - nums[i] - 1;
            nums[i] += nums[i - 1];
            res += nums[i] - (j < 0 ? 0 : nums[j]);
        }
        return res;
    }

    public int subarraySum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                ans += nums[j];
            }
        }

        return ans;
    }
}
