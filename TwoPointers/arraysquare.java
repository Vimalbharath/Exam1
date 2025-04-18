package TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/description/

public class arraysquare {

    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1;
        while (start < end) {
            int left = Math.abs(nums[start]) * Math.abs(nums[start]);
            int right = Math.abs(nums[end]) * Math.abs(nums[end]);
            if (left > right) {
                ans[index] = left;
                start++;
            } else {
                ans[index] = right;
                end--;
            }
            index--;
        }
        ans[index] = Math.abs(nums[start]) * Math.abs(nums[start]);

        return ans;
    }

    public int[] sortedSquaresbf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

}
