package TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/count-the-number-of-fair-pairs/editorial/?envType=daily-question&envId=2025-04-19

public class fairpairs {

    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);
        return bound(nums, upper + 1) - bound(nums, lower);

    }

    public long bound(int[] nums, int val) {
        long ans = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < val) {
                ans = ans + (right - left);
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
