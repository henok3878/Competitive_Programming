package leet_code.java;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        
        int i = 0; 
        int longest = 0;
        int zeros = 0;
        for(int j = 0; j < nums.length; j++){
            if (nums[j]==0) zeros++;
            if (zeros > k) {
                if (nums[i]==0) zeros--;
                i++;
            }
            if (zeros <= k) longest = Math.max(longest, j -i +1 );
        }
        return longest;
    }
}
