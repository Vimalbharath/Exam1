package Prefixsum;

//https://leetcode.com/problems/maximum-score-after-splitting-a-string/?envType=problem-list-v2&envId=prefix-sum
public class maxscore {

    public int maxScore(String s) {
        int[] prefix = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                prefix[i] = 1;
            } else {
                prefix[i] = 0;
            }
        }

        for (int i = prefix.length - 1; i > 0; i--) {
            prefix[i - 1] = prefix[i - 1] + prefix[i];

        }
        int max = Integer.MIN_VALUE;
        int zero = 0;
        int lastone=0;
        int lastzero=0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                 lastone=i;
            }

            if (s.charAt(i) == '0') {
               
                zero++;
                 lastzero=i;
            }
            if ((zero + prefix[i]) > max) {
                max = zero + prefix[i];
            }
        }
        if(zero==0 || lastone<lastzero){
            return max-1;
        }
        return max;
    }
}
