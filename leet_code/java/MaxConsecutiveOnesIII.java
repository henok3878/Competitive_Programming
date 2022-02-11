package leet_code.java;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        
        int i = 0; 
        int longest = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 0) k--;
            if (k < 0 && nums[i++] == 0) k++;
            longest = Math.max(longest,j - i + 1);  
        }
        
        return longest;
    }
}
