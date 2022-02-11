package leet_code.java;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,10001);
        dp[nums.length-1] = 0;
        for(int i = nums.length -2; i >= 0 ; i--){
            int min = Integer.MAX_VALUE;
            for(int j = i; j <= (i + nums[i]); j++){
                if(j >= nums.length) break;
                min = Math.min(min,dp[j] + 1);
            }
            dp[i] = min;
        } 
        return dp[0];
    }
}
