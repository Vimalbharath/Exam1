package TwoPointers;

import java.util.Arrays;

public class threesum {
    public static boolean three(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    return true;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 40, 20, 10, 3, 6, 7 };
        int target = 24;

        // Call the twoSum function and print the result
        if (three(arr, target)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}