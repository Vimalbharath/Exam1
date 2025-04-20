package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class maxallsub {

    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        int n = arr.length;

        // to store the results
        ArrayList<Integer> res = new ArrayList<Integer>();

        // create deque to store max values
        Deque<Integer> dq = new ArrayDeque<Integer>();

        int i = 0;
        int j = 0;

        while (j < n) {
            while (dq.size() > 0 && dq.peek() < arr[j]) {
                dq.pop();
            }
            dq.add(arr[j]);
            if (j - i + 1 < k) {

                j++;
            } else if (j - i + 1 == k) {

                res.add(dq.peek());

                j++;

            }
            if (j - i + 1 > k) {
                if (dq.peek() == arr[i])
                    dq.pop();
                i++;

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 1, 7, 3 };
        int k = 3;
        ArrayList<Integer> res = maxOfSubarrays(arr, k);
        for (int maxVal : res) {
            System.out.print(maxVal + " ");
        }
    }
}
