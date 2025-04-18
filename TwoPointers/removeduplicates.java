package TwoPointers;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class removeduplicates {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];

            }

        }
        return j + 1;
    }

    public int removeDuplicates1(int[] nums) {
        // Initialize index to keep track of the new array length
        int index = 0;

        // Iterate through the array elements
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if the current element is the same as the next element
            if (nums[i] == nums[i + 1]) {
                // If it is, skip to the next iteration without updating the array
                continue;
            } else {
                // If it's not, update the array with the current element at the new index
                nums[index] = nums[i];
                // Increment the index to prepare for the next unique element
                index++;
            }
        }

        // After the loop, add the last element of the original array to the updated
        // array
        nums[index] = nums[nums.length - 1];

        // Return the length of the updated array (number of unique elements)
        return ++index;
    }
}
