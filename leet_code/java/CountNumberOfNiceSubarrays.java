package leet_code.java;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int ans = 0;
        int left = 0, prevLeft = -1, right = 0, oddCount = 0;
        while(left < nums.length && nums[left] % 2 == 0){
            left++;
            right++;
        }
        while(right < nums.length){
            int currAdd = (nums[right] % 2 == 0) ? 0 : 1;
            if((oddCount + currAdd) == k){
                oddCount += currAdd;
                ans += 1 + (left - prevLeft - 1);
                right++;
            }
            else if((oddCount + currAdd )< k){
                oddCount+= currAdd;
                right++;
            }else{
                oddCount--;
                prevLeft = left;
                left++;
                while(nums[left] % 2 == 0) left++;
            }
        }
        return ans;
    }
}
