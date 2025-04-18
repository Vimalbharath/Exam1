package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/2-sum-pair-sum-closest-to-target/

public class closestsum {

    public static List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        int diff = Integer.MAX_VALUE;

        while (left < right) {
            int currsum = arr[left] + arr[right];
            if (Math.abs(target - currsum) < diff) {
                diff = Math.abs(target - currsum);
                res = Arrays.asList(arr[left], arr[right]);
            }
            if (currsum > target) {
                right--;
            }
            if (currsum < target) {
                left++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 60, -10, 70, -80, 85 };
        int target = 0;

        List<Integer> res = sumClosest(arr, target);
        if (res.size() > 0)
            System.out.println(res.get(0) + " " + res.get(1));
    }
}
