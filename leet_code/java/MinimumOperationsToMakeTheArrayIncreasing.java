package leet_code.java;

public class MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int ans = 0;
        for(int i = 1; i < nums.length ; i++){
            int dif = nums[i-1] - nums[i];
            dif = (dif >= 0) ? dif + 1 : 0;
            nums[i]+= dif;
            ans += dif;
        }
        return ans;
    }
}
