package DP.mcm;

public class eggdrop {
    public static int minattempt(int e, int f) {

        if (e == 1) {
            return f;
        }
        if (f == 1 || f == 0) {
            return f;
        }

        int attempt = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int ans = 1 + Math.max(minattempt(e - 1, k - 1), minattempt(e, f - k));
            attempt = Math.min(attempt, ans);
        }
        return attempt;
    }

    public static void main(String[] args) {
        int e = 2;
        int f = 10;
        System.out.println(minattempt(e, f));
    }
}
