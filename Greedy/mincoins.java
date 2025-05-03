package Greedy;

import java.util.Arrays;

public class mincoins {
    public static int mincoin(int[] arr, int sum) {
        Arrays.sort(arr);
        int coin = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxelement = arr[i];
            coin = coin + sum / maxelement;
            sum = sum % maxelement;
            if (sum == 0) {
                break;
            }
        }
        return coin;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 10 };
        int sum = 39;
        System.out.println(mincoin(arr, sum));
    }
}
