package DP.mcm;

import java.util.Arrays;

public class eggdrop {
    public static int minattempt(int e, int f, int[][] dp) {

        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        if (e == 1) {
            return f;
        }
        if (f == 1 || f == 0) {
            return f;
        }

        int attempt = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int left = dp[e - 1][k - 1];
            if (dp[e - 1][k - 1] == -1) {
                left = minattempt(e - 1, k - 1, dp);
                dp[e - 1][k - 1] = left;
            }
            int right = dp[e][f - k];
            if (dp[e][f - k] == -1) {
                left = minattempt(e, f - k, dp);
                dp[e][f - k] = right;
            }
            int ans = 1 + Math.max(left, right);
            attempt = Math.min(attempt, ans);
        }
        return dp[e][f] = attempt;
    }

    public static void main(String[] args) {
        int e = 2;
        int f = 100;
        int[][] dp = new int[e + 1][f + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(minattempt(e, f, dp));
    }
}
