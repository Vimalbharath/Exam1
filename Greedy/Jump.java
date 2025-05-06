package Greedy;

public class Jump {
    public boolean canJump(int[] nums) {
        int currentreach = 0;
        int n = nums.length;
        int maxreach = 0;
        for (int i = 0; i < nums.length; i++) {
            maxreach = Math.max(i + nums[i], maxreach);
            if (maxreach >= n - 1)
                return true;
            if (i == currentreach) {
                if (i == maxreach) {
                    return false;
                } else {
                    currentreach = maxreach;
                }
            }
        }
        return true;
    }
}
