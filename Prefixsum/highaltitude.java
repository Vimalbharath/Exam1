package Prefixsum;

//https://leetcode.com/problems/find-the-highest-altitude/?envType=problem-list-v2&envId=prefix-sum

public class highaltitude {
    public int largestAltitude(int[] gain) {
        int[] prefix = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            prefix[i + 1] = gain[i];
        }
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] > max) {
                max = prefix[i];
            }
        }
        return max;
    }
}
