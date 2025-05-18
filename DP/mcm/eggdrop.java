package DP.mcm;

public class eggdrop {
    public static int minattempt(int e, int f) {
        if (e == 0 || f == 0) {
            return 0;
        }
        int attempt = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int ans = Math.min(minattempt(e, k), minattempt(e - 1, f - k));
            attempt = Math.min(attempt, ans);
        }
        return attempt;
    }

    public static void main(String[] args) {
        int e = 3;
        int f = 5;
        System.out.println(minattempt(e, f));
    }
}
