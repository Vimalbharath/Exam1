package Prefixsum;

public class pivotindex {
    public int pivotIndex(int[] nums) {
        int ans = -1;
        int prefixsum = 0;
        int suffixsum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixsum = prefixsum + nums[i];
            suffixsum = suffixsum + nums[nums.length - i - 1];
            if (prefixsum == suffixsum) {
                ans = i;
            }
        }
        return ans;
    }
}
