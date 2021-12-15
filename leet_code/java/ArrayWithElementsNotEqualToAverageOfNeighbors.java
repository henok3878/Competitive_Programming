package leet_code.java;

import java.util.Arrays;

import leet_code.java.util.Utility;

public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i  < nums.length; i+= 2){
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
        }
        return nums;
    }


    public static void main(String[] args){
        ArrayWithElementsNotEqualToAverageOfNeighbors arrayWithElementsNotEqualToAverageOfNeighbors = new ArrayWithElementsNotEqualToAverageOfNeighbors();
        //int[] nums = {1,2,3,4,5};
        int[] nums = {6,2,0,9,7};
        int[] ans = arrayWithElementsNotEqualToAverageOfNeighbors.rearrangeArray(nums);
        System.out.println("Result: ");
        Utility.printArray(ans);
    }
}
