package TwoPointers;

import java.util.Arrays;

public class threesum {
    public static boolean three(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            int reqsum = target - arr[i];
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == reqsum) {
                    return true;
                }
                if (sum > reqsum) {
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