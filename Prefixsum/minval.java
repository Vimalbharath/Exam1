package Prefixsum;

public class minval {

    public int minStartValue(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix = nums;
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length - 1; i++) {
            prefix[i] += prefix[i - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] < min) {
                min = prefix[i];
            }
        }
        return Math.abs(min) + 1;

    }

}
