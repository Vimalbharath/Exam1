package Prefixsum;

//https://leetcode.com/problems/sum-of-variable-length-subarrays/description/?envType=problem-list-v2&envId=prefix-sum

public class varsubarray {
    public int subarraySum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                ans = ans + nums[start];
            }
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return ans - 1;
    }
}
