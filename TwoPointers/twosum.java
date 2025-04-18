package TwoPointers;

import java.util.Arrays;

public class twosum {
    public static boolean twoSum1(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (right > left) {
            if (arr[left] + arr[right] == target) {
                return true;
            }
            if (arr[left] + arr[right] > target) {
                right--;
            }
            if (arr[left] + arr[right] < target) {
                left++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        // Call the twoSum function and print the result
        if (twoSum1(arr, target)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}