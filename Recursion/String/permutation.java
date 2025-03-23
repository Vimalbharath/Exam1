package Recursion.String;

public class permutation {
    public static void main(String[] args) {
        perm("", "abc");
    }

    public static void perm(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i < p.length(); i++) {
            p = p.substring(0, i) + ch + p.substring(i, p.length());
            perm(p, up.substring(1));

        }
    }
}
