package DP.lcs;

import java.util.ArrayList;

public class printscs2 {
    public static int scs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        ArrayList<Character> list = new ArrayList<>();
        int m = s1.length();
        int n = s2.length();
        while (m != 0 && n != 0) {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                list.add(0, s1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (dp[m][n - 1] > dp[m][n]) {
                    list.add(0, s2.charAt(n - 1));
                    n--;
                } else {
                    list.add(0, s1.charAt(m - 1));
                    m--;
                }
            }
        }
        while (m != 0) {
            list.add(0, s1.charAt(m - 1));
            m--;
        }
        while (n != 0) {
            list.add(0, s2.charAt(n - 1));
            n--;
        }
        for (Character a : list) {
            System.out.print(a + " ");
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "vimalbharathkumar";
        String s2 = "rath";
        System.out.println(scs(s1, s2));
    }
}
