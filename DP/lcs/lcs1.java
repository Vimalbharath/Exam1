package DP.lcs;

//https://leetcode.com/problems/longest-common-subsequence/?envType=problem-list-v2&envId=dynamic-programming

import java.util.Arrays;

public class lcs1 {
    public static int longestCommonSubsequence(String text1, String text2, int[][] memo) {

        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }
        return longestCommonSubsequence(text1, text2, text1.length(), text2.length(), memo);
    }

    public static int longestCommonSubsequence(String text1, String text2, int l1, int l2, int[][] memo) {
        if (memo[l1][l2] != -1) {
            return memo[l1][l2];
        }
        if (l1 == 0 || l2 == 0) {
            return memo[l1][l2] = 0;
        }
        if (text1.charAt(l1 - 1) == text2.charAt(l2 - 1)) {
            return memo[l1][l2] = 1 + longestCommonSubsequence(text1, text2, l1 - 1, l2 - 1, memo);
        } else {
            return memo[l1][l2] = Math.max(longestCommonSubsequence(text1, text2, l1, l2 - 1, memo),
                    longestCommonSubsequence(text1, text2, l1 - 1, l2, memo));
        }
    }

    public static void main(String[] args) {
        String text1 = "vimala";
        String text2 = "avighagmahklb";
        int memo[][] = new int[text1.length() + 1][text2.length() + 1];
        System.out.println(longestCommonSubsequence(text1, text2, memo));
        for (int[] a : memo) {
            for (int b : a) {
                System.out.print(b + "  ");
            }
            System.out.println();
        }
    }
}
