package DP.mcm;

import java.util.Arrays;

public class palindromepart1 {
    public static boolean isPalindrome(String str, int i, int j) {
        if (i == j) {
            return true;
        }
        if (i > j) {
            return true;
        }
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }

    public static int pp(String str, int s, int e, int[][] dp) {
        if (dp[s][e] != -1) {
            return dp[s][e];
        }
        if (s >= e) {
            return dp[s][e] = 0;
        }
        if (isPalindrome(str, s, e) == true) {
            return dp[s][e] = 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = s; k <= e - 1; k++) {
            int temp = pp(str, s, k, dp) + 1 + pp(str, k + 1, e, dp);
            ans = Math.min(temp, ans);
        }
        return dp[s][e] = ans;
    }

    public static void main(String[] args) {
        String a = "nitim";
        int[][] dp = new int[a.length() + 1][a.length() + 1];
        for (int[] b : dp) {
            Arrays.fill(b, -1);
        }
        System.out.println(pp(a, 0, a.length() - 1, dp));
        System.out.println(isPalindrome(a, 0, 4));

        for (int[] c : dp) {
            for (int d : c) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}