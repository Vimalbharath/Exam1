package DP.zeroone;

//https://leetcode.com/problems/coin-change-ii/?envType=problem-list-v2&envId=dynamic-programming
public class CountCoin2 {

    public static int change(int amt, int[] coins) {
        int[][] dp = new int[coins.length + 1][amt + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {

            for (int j = 1; j <= amt; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int[] a : dp) {
            for (int b : a) {
                System.out.print(b + "  ");
            }
            System.out.println();
        }

        return dp[coins.length][amt];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amt = 5;
        System.out.println(change(amt, coins));
    }

}
