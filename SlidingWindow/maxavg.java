package SlidingWindow;

public class maxavg {

    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        int j = 0;
        int sum = 0;
        double maxsum = Double.NEGATIVE_INFINITY;
        double avg = Double.NEGATIVE_INFINITY;
        while (j < n) {
            sum += nums[j];
            avg = (double) sum / (j - i + 1);
            if (j - i + 1 < k) {

                j++;
            } else if (j - i + 1 == k) {

                if (maxsum < avg) {
                    maxsum = avg;
                }

                j++;

            }
            if (j - i + 1 > k) {
                sum -= nums[i];
                i++;

            }
        }
        return maxsum;
    }
}
