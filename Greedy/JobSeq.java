package Greedy;

import java.util.ArrayList;

public class JobSeq {
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>>=new ArrayList<>();
        return ans;

    }

    public static void main(String[] args) {
        int[] deadline = { 2, 1, 2, 1, 1 };
        int[] profit = { 100, 19, 27, 25, 15 };

        ArrayList<Integer> ans = jobSequencing(deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
