package leet_code.java;

public class JumpGame {
    
    public boolean canJump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        
        int lastIdx = nums.length - 1;
        for(int i = lastIdx; i >= 0; i--){
            if((i + nums[i] >= lastIdx)) reachable[i] = true;
            else{
                for(int j = i; j <=  (i + nums[i]); j++){
                    if(reachable[j]){
                        reachable[i] = true;
                        break;
                    }
                }
            }
        }
         return reachable[0];
        
    }
    
}
