package Prefixsum;

//https://leetcode.com/problems/maximum-score-after-splitting-a-string/?envType=problem-list-v2&envId=prefix-sum
public class maxscore {

    public int maxScore(String s) {
        int[] prefix = new int[s.length()];
        // for (int i = 0; i < s.length(); i++) {
        // prefix[i] = (int) (s.charAt(i));
        // }
        int ones = 0;
        for (int i = prefix.length - 1; i >= 0; i--) {
            prefix[i] = ones;
            if (s.charAt(i) == '1') {
                ones++;
            }

        }
        int max = Integer.MIN_VALUE;
        int zero = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            }
            if ((zero + prefix[i]) > max) {
                max = zero + prefix[i];
            }
        }
        return max;
    }
}
