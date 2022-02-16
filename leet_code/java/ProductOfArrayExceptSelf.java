package leet_code.java;
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int[] left = new int[nums.length];
        left[0] = nums[0];
        for(int i = 1; i < nums.length ; i++) left[i] = left[i-1] * nums[i];
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) right[i] = right[i + 1] * nums[i];
        
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int prodLeft = (i - 1 ) < 0 ? 1 : left[i-1];
            int prodRight = (i + 1) < nums.length ? right[i + 1] : 1;
            ans[i] = prodLeft * prodRight;
        }
        
        return ans;
    }
}
