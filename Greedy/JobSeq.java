package Greedy;

import java.util.ArrayList;

public class JobSeq {
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = deadline.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>(2));
            list.get(i).add(profit[i]);
            list.get(i).add(deadline[i]);
        }

        list.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        int start = -1;
        int totprofit = 0;
        int count = 0;
        int[] slot = new int[n];
        for (int i = 0; i < n; i++) {
            start = list.get(i).get(1);
            for (int j = start; j >= 0; j--) {
                if (slot[j] == 0) {
                    slot[j] = 1;
                    totprofit += list.get(i).get(0);
                    count++;
                }
            }

        }
        ans.add(totprofit);
        ans.add(count);
        return ans;

    }

    public static void main(String[] args) {
        int[] deadline = { 2, 1, 2, 1, 1 };
        int[] profit = { 100, 19, 27, 25, 15 };

        ArrayList<Integer> ans = jobSequencing(deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
