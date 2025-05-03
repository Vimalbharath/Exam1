package Greedy;

import java.util.PriorityQueue;

public class Activity {
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
            if (finishtime < cf) {
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
                activitySelection(start, finish));
    }
}
