package leet_code.java;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int currMax = 0;
        int max = nums[0];   
        for(int num : nums){
            currMax = Math.max(currMax + num,num);
            max = Math.max(max,currMax);
        }
        return max;
    }
    
}
