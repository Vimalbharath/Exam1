package DP.lcs;

import java.util.ArrayList;

//https://leetcode.com/problems/longest-common-subsequence/?envType=problem-list-v2&envId=dynamic-programming

import java.util.Arrays;

public class lcs2 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int memo[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1) && i != j) {
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
        ArrayList<Character> list = new ArrayList<>();
        int m = memo.length - 1;
        int n = memo[0].length - 1;
        while (m != 0 && n != 0) {
            if (text1.charAt(m - 1) == text2.charAt(n - 1) && m != n) {
                list.add(0, text1.charAt(m - 1));
                n--;
                m--;
            } else {
                if (memo[m - 1][n] > memo[m][n - 1]) {
                    m--;
                } else {
                    n--;
                }
            }
        }
        for (Character a : list) {
            System.out.print(a + " ");
        }
        return memo[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "vimala";
        String text2 = "avighagmahklb";
        String text3 = "aabcbdc";

        System.out.println(longestCommonSubsequence(text3, text3));

    }
}
