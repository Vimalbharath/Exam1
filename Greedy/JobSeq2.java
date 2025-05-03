package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class JobSeq2 {
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        ArrayList<Integer> ans = new ArrayList<>(2);
        int n = deadline.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>(2));
            list.get(i).add(profit[i]);
            list.get(i).add(deadline[i]);
        }

        list.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ArrayList<Integer> job : list) {

            // If job can be scheduled within its deadline
            if (job.get(1) > pq.size()) {
                pq.add(job.get(0));
            }

            // Replace the job with the lowest profit
            else if (!pq.isEmpty() && pq.peek() < job.get(0)) {
                pq.poll();
                pq.add(job.get(0));
            }
        }
        int count = 0;
        int totprofit = 0;

        while (!pq.isEmpty()) {
            totprofit += pq.poll();
            count += 1;
        }
        ans.add(count);
        ans.add(totprofit);
        return ans;

    }

    public static void main(String[] args) {
        int[] deadline = { 2, 1, 2, 1, 1 };
        int[] profit = { 100, 19, 27, 25, 15 };

        ArrayList<Integer> ans = jobSequencing(deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
