package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class firstneg {

    public static int[] firstNegInt(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;

        // create deque to store max values
        Deque<Integer> dq = new ArrayDeque<Integer>();

        int i = 0;
        int j = 0;

        while (j < n) {

            if (arr[j] < 0)
                dq.add(arr[j]);
            if (j - i + 1 < k) {

                j++;
            } else if (j - i + 1 == k) {

                if (dq.size() != 0) {
                    res.add(dq.peek());
                } else {
                    res.add(0);
                }

                j++;

            }
            if (j - i + 1 > k) {
                if (dq.size() != 0) {
                    if (dq.peek() == arr[i])
                        dq.pop();
                }
                i++;

            }
        }

        // Convert List to int[]
        return res.stream().mapToInt(a -> a).toArray();

    }

    public static void main(String[] args) {
        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        int[] res = firstNegInt(arr, k);
        System.out.print(Arrays.toString(res));
    }
}
