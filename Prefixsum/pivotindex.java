package Prefixsum;

public class pivotindex {
    public int pivotIndex(int[] nums) {
        int ans = -1;
        int size = nums.length;
        int prefixsum[] = new int[size];
        int suffixsum[] = new int[size];
        prefixsum[0] = nums[0];
        suffixsum[size - 1] = nums[size - 1];

        for (int i = 1; i < nums.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }

        for (int i = size - 2; i >= 0; i--) {
            suffixsum[i] = suffixsum[i + 1] + nums[i];
        }

        for (int i = 0; i < size; i++) {
            if (prefixsum[i] == suffixsum[i]) {
                ans = i;
            }

        }

        return ans;
    }
}