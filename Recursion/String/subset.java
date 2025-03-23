package Recursion.String;

import java.util.ArrayList;

public class subset {
    public static void main(String[] args) {

        ArrayList<String> ans = sub2("", "abc");
        System.out.println(ans);
    }

    public static void sub(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        sub(p, up.substring(1));

        sub(p + ch, up.substring(1));

    }

    public static ArrayList<String> sub2(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> first = sub2(p, up.substring(1));

        ArrayList<String> second = sub2(p + ch, up.substring(1));

        first.addAll(second);
        return first;

    }
}
