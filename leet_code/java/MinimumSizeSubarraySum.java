package leet_code.java;

import java.util.Arrays;

public class MinimumSizeSubarraySum {


    public int minSubArrayLen(int target, int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int[] prefixSum = new int[nums.length+1];
        for(int i = 1; i <= nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i - 1];   
        }
        System.out.println(Arrays.toString(prefixSum));
        while(right < prefixSum.length){
            if(prefixSum[right] - prefixSum[left] > target){
                min = Math.min(min,right - left);
                left++;
            }
            else{
                if(prefixSum[right] - prefixSum[left] == target){
                   min = Math.min(min,right - left);   
                }
                right++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    public static void main(String[] args){
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        int result = minimumSizeSubarraySum.minSubArrayLen(target, nums);
        System.out.println("Ans: " + result);
    }
    
}
