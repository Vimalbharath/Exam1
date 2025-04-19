package TwoPointers;

import java.util.Arrays;
import java.util.List;

public class pairlessthantarget {

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
