package SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class duplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        int j = 0;
        Set<Integer> set = new HashSet<Integer>();
        while (j < n) {

            if (j - i + 1 < k) {
                set.add(nums[j]);
                j++;
                if (j < n) {
                    if (set.contains(nums[j]))
                        return true;
                }

            }
            // if (j - i + 1 == k) {

            // if (set.contains(nums[j]))
            // return true;

            // j++;

            // }
            if (j - i + 1 >= k) {
                set.remove(nums[i]);
                i++;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 2, 3 };
        int k = 3;

        System.out.println(containsNearbyDuplicate(arr, k));
    }
}
