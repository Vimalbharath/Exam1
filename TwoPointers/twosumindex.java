package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twosumindex {
    public int[] twoSumhashextra(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }

        return new int[] {}; // No solution found
    }

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
