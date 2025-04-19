package Prefixsum;

//https://leetcode.com/problems/range-sum-query-immutable/description/?envType=problem-list-v2&envId=prefix-sum
public class rangesum {
    class NumArray {
        int[] presum;

        public NumArray(int[] nums) {
            presum = nums;
            presum[0] = nums[0];
            for (int i = 1; i < presum.length; i++) {
                presum[i] += presum[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0)
                return presum[right];
            return presum[right] - presum[left - 1];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
}
