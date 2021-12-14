package leet_code.java;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        int maxSoFar = 1;
        long sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            if (sum + k < nums[right] * (right - left + 1)) {
                sum -= nums[left];
                left++;
            }
            
            maxSoFar = Math.max(maxSoFar, right - left + 1);
        }
        
        return maxSoFar;
    }


    public static void main(String[] args){

        FrequencyOfTheMostFrequentElement frequencyOfTheMostFrequentElement = new FrequencyOfTheMostFrequentElement();
        // input  [1,2,4,8,13], k = 5
        int nums[] = {3,9,6};
        int k = 2;
        int result = frequencyOfTheMostFrequentElement.maxFrequency(nums, k);
        System.out.println("Result : " + result);
    }
    
}
