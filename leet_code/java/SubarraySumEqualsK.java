package leet_code.java;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        
        for(int i = 1; i < sum.length; i++) sum[i] = nums[i-1] + sum[i-1];
        
        int ans = 0;
        
        for(int i = 0; i < sum.length; i++){
            for(int j = i + 1; j < sum.length; j++) if(sum[j] - sum[i] == k) ans++;
        }
        
        return ans;
    }
}
