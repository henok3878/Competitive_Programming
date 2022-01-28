package leet_code.java;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while(j < nums.length){
            if(j < nums.length && nums[j] == nums[i]) j++;
            else  if(nums[j] == nums[i]) break;
            else nums[++i] = nums[j];
        }
        return i + 1;
    }
}
