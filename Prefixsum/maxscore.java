package Prefixsum;

//https://leetcode.com/problems/maximum-score-after-splitting-a-string/?envType=problem-list-v2&envId=prefix-sum
public class maxscore {

    public int maxScore(String s) {
        int[] prefix=new int[s.length];
        for(int i=0;i<s.length;i++){
            prefix[i]=int(s.charAt(i));
        }
         for(int i=1;i<prefix.length;i++){
            prefix[i]+=prefix[i-1];
        }
        int max=Integer.MIN;
        int zero=0;
         for(int i=0;i<s.length;i++){
           if(s.charAt(i)=='0'){
                zero++;
           }
           if(zero+prefix[i]>max){
            max=zero+prefix[i];
           }
        }
        return max;
    }
}
