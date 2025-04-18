package TwoPointers;

import java.util.Arrays;

public class twosumindex {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (right > left) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                int ans[] = new int[2];
                ans[0] = left;
                ans[1] = right;
                return ans;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
