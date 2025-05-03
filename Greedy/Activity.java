package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Activity {

    public static int activitySelection2(int[] start, int[] finish) {
        int n = finish.length;
        int[][] newset = new int[n][2];
        for (int i = 0; i < n; i++) {
            newset[i][0] = start[i];
            newset[i][1] = finish[i];
        }

        Arrays.sort(newset, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int finishtime = -1;

        for (int j = 0; j < n; j++) {
            if (finishtime < newset[j][0]) {
                count++;
                finishtime = newset[j][1];
            }
        }
        return count;
    }

    public static int activitySelection(int[] start, int[] finish) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < finish.length; i++) {
            pq.add(new int[] { start[i], finish[i] });
        }

        int finishtime = -1;
        int count = 0;

        while (!pq.isEmpty()) {
            int ans[] = pq.poll();
            int cf = ans[1];
            if (finishtime < ans[0]) {
                count++;
                finishtime = cf;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] finish = { 2, 4, 6, 7, 9, 9 };

        System.out.println(
                activitySelection2(start, finish));
    }
}
