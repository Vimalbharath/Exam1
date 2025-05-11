package DP.lcs;

//https://leetcode.com/problems/longest-common-subsequence/?envType=problem-list-v2&envId=dynamic-programming

import java.util.Arrays;

public class lcs2 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int memo[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        for (int[] a : memo) {
            for (int b : a) {
                System.out.print(b + "  ");
            }
            System.out.println();
        }
        return memo[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "vimala";
        String text2 = "avighagmahklb";

        System.out.println(longestCommonSubsequence(text1, text2));

    }
}
