package leet_code.java;

public class HouseRobber {

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0],dp[1]);
        for(int i = 2; i < nums.length; i++){
            int prev2 = (i-3 < 0) ? 0 : dp[i-3];
            dp[i] = Math.max(dp[i-2],prev2) + nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    
}
