package leet_code.java;

public class LongestSubarrayof1AfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, longest = 0;
        int zeroIdx = -1;
        while(right < nums.length){
            if(nums[right] == 0){ // nums[right] == 0
                if(zeroIdx != -1){ // nums[right] == 0 && we haven't deleted any elem yet
                    left = zeroIdx + 1;
                }
                zeroIdx = right;
            }
            longest = Math.max(longest,right-left);
            right++;
        }
        return longest;
    }
}
