package TwoPointers;

import java.util.List;

public class pairlessthantarget {

    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        for (int num : nums) {
            int val = target - num;
            for (int snum : nums) {
                if (snum < val) {
                    if (snum == num) {
                        ans--;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
