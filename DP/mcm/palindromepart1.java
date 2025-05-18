package DP.mcm;

public class palindromepart1 {
    public static boolean isPalindrome(String str, int i, int j) {
        if (i == j) {
            return true;
        }
        if (i > j) {
            return true;
        }
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }

    public static int pp(String str, int s, int e) {
        if (s >= e) {
            return 0;
        }
        if (isPalindrome(str, s, e) == true) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = s; k <= e - 1; k++) {
            int temp = pp(str, s, k) + 1 + pp(str, k + 1, e);
            ans = Math.min(temp, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "nitim";
        System.out.println(pp(a, 0, a.length() - 1));
        System.out.println(isPalindrome(a, 0, 4));
    }
}