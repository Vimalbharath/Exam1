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
            if (j - i > k) { // Correction: Shrink window when size exceeds k
                set.remove(nums[i]);
                i++;
            }

            if (set.contains(nums[j])) { // Correction: Check for duplicate before adding
                return true;
            }

            set.add(nums[j]);
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 2, 3 };
        int k = 3;

        System.out.println(containsNearbyDuplicate(arr, k));
    }
}
