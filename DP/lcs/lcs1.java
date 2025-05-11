package DP.lcs;

public class lcs1 {
    public static int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    public static int longestCommonSubsequence(String text1, String text2, int l1, int l2) {
        if (l1 == 0 || l2 == 0) {
            return 0;
        }
        if (text1.charAt(l1) == text2.charAt(l2)) {
            return 1 + longestCommonSubsequence(text1, text2, l1 - 1, l2 - 1);
        } else {
            return Math.max(longestCommonSubsequence(text1, text2, l1, l2 - 1),
                    longestCommonSubsequence(text1, text2, l1 - 1, l2));
        }
    }

    public static void main(String[] args) {
        String text1 = "vimala";
        String text2 = "avighagmahklb";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
