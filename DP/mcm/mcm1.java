package DP.mcm;

public class mcm1 {
    public static int matrixMultiplication(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; j++) {
            int temp = matrixMultiplication(arr, i, k) + matrixMultiplication(arr, k + 1, j) +
                    (arr[i - 1] + arr[k - 1] + arr[j - 1]);
            if (temp < ans) {
                ans = temp;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4 };
        System.out.println(matrixMultiplication(arr, 1, arr.length - 1));
    }
}
