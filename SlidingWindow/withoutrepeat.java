package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class withoutrepeat {
    public static int longestUniqueSubstr(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int i = 0;
        int j = 0;
        int maxarrl = 0;
        int arrl = 0;
        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            int count = map.size();

            if (count < j - i + 1) {
                char cha = s.charAt(i);
                if (map.get(cha) == 1) {
                    map.remove(cha);
                } else {
                    map.put(cha, map.get(cha) - 1);
                }
                i++;
                // j++;
            }

            arrl = j - i + 1;
            if (arrl > maxarrl) {
                maxarrl = arrl;
            }
            j++;

        }
        return maxarrl;
    }

    public static void main(String[] args) {
        String s = "arwvivbgvtybtnudd";
        System.out.println(longestUniqueSubstr(s));
    }
}
