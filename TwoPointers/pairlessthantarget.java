package TwoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pairlessthantarget {

    public int countPairs2(List<Integer> nums, int target) {
        int ans = 0;
        int left = 0;
        int right = nums.size();
        Collections.sort(nums);

        while (right > left) {
            int sum = nums.get(left) + nums.get(right);

            if (sum < target) {
                ans = ans + (right - left);
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public int countPairs3(List<Integer> nums, int target) {

        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target)
                    res++;
            }
        }
        return res;
    }

    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {

            for (int j = 0; j < nums.size(); j++) {

                if (i < j && (nums.get(i) + nums.get(j)) < target) {

                    ans++;
                }
            }
        }
        return ans;
    }
}
