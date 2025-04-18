package TwoPointers;

import java.util.Arrays;

public class twosumindex {
    public int[] twoSumhash(int[] a, int t) {
        var m = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if (m.containsKey(t - a[i]))
                return new int[] { m.get(t - a[i]), i };
            m.put(a[i], i);
        }
        return null;
    }

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
                // return new int[] {left,right};
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
