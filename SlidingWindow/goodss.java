package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/?envType=problem-list-v2&envId=sliding-window

public class goodss {

    public int countGoodSubstrings(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < n) {
            set.add(s.charAt(j));
            if (j - i + 1 < 3) {
                j++;
            }
            if (j - i + 1 == 3) {
                if (set.size() == 3) {
                    ans++;
                }
                set.remove(s.charAt(i));
                j++;
                i++;
            }
            if (j - i + 1 > 3) {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
