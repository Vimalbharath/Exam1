package DP.zeroone;

public class MinCoin2 {
    public static int count(int amt, int[] coins) {
        int[][] dp = new int[coins.length + 1][amt + 1];
        for (int i = 0; i <= amt; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i <= amt; i++) {
            if (amt % i == 0) {
                dp[1][i] = amt / i;
            } else {
                dp[1][i] = Integer.MAX_VALUE - 1;
            }
        }
        for (int i = 2; i <= coins.length; i++) {
            for (int j = 1; j <= amt; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j - coins[i - 1]], dp[i - 1][j]);
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
        System.out.println(count(amt, coins));
    }

}
