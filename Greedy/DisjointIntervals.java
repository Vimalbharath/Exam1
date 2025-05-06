package Greedy;

import java.util.Arrays;

public class DisjointIntervals {
    static int[][] getDisjoint(int[][] arr) {
        int[][] res = new int[arr.length][2];
        int count = -1;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int currentstart = 0;
        for (int[] pair : arr) {
            int start = pair[0];
            int end = pair[1];
            if (currentstart < start) {
                count++;
                res[count][0] = start;
                res[count][1] = end;
                currentstart = end;

            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 9 }, { 2, 3 }, { 5, 7 } };

        // Call getDisjoint function
        int[][] ans = getDisjoint(arr);

        // Print the maximal disjoint intervals
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }
}
