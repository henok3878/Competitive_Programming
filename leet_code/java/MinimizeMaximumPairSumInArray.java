package leet_code.java;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int maxPairSum = 0;
        for(int i = 0; i < mid; i++){
            int currentPairSum = nums[i] + nums[nums.length - i-1];
            if(maxPairSum < currentPairSum){
                maxPairSum = currentPairSum;
            }
        }
        return maxPairSum;
        
    }


    public static void main(String[] args){
        int[] nums = {3,5,4,2,4,6};
        MinimizeMaximumPairSumInArray minimizeMaximumPairSumInArray = new MinimizeMaximumPairSumInArray();
        int ans = minimizeMaximumPairSumInArray.minPairSum(nums);
        System.out.println("Result: " + ans);
    }
    
}
