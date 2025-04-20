package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class goodss {

    public int countGoodSubstrings(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < n) {

            if (j - i + 1 < 3) {
                j++;
            }
            if (j - i + 1 == 3) {

                j++;
            }
            if (j - i + 1 > 3) {
                i++;
            }
        }
    }
}
