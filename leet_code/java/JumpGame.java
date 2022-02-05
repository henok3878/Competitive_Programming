package leet_code.java;

public class JumpGame {
    
    public boolean canJump(int[] nums) {
        int lastIdx = nums.length - 1;
        for(int i = lastIdx; i >= 0; i--){
            if((i + nums[i] >= lastIdx)) lastIdx = i;
        }
        return nums[0] >= lastIdx;
                
    }
    
}
