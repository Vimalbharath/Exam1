package Recursion.String;

public class subseq {
    public static void main(String[] args) {

        sub("", "abcabc");
    }

    public static void sub(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        up = up.substring(1);
        if (ch == 'a') {
            sub(p, up);
        } else {
            sub(p + ch, up);
        }
    }

}