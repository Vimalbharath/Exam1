package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class kunique {

    public static int longestKSubstr(String s, int k) {
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

            if (count < k) {

                j++;
            }
            if (count == k) {
                arrl = j - i + 1;
                if (arrl > maxarrl) {
                    maxarrl = arrl;
                }
                j++;
            }
            if (count > k) {
                char cha = s.charAt(i);

                if (map.get(cha) == 1) {
                    map.remove(cha);
                } else {
                    map.put(cha, map.get(cha) - 1);
                }
                i++;
            }
        }
        return maxarrl;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        System.out.println(longestKSubstr(s, k));
    }
}
