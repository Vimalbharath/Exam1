package Prefixsum;

public class pivotindex {
    public int pivotIndex(int[] nums) {
        int ans=-1;
        int size=nums.length;
        int prefixsum[]=new int[size-1];
        int suffixsum[]new int[size-1];
        prefixsum[0]=nums[0];
        suffixsum[size-1]=nums[size-1];

        for(int i=1;i<nums.length;i++){
            prefixsum[i]=prefixsum[i-1]+nums[i];
            suffixsum[size-i-1]=0;
        }
    }
}
