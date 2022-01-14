package leet_code.java;

public class TargetSum {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        findTargetHelper(nums,0,target);
        return ans;
    }
    
    private void findTargetHelper(int[] nums, int idx, int target){
       if(target == 0 && nums.length == idx){
           ans = ans + 1;
       }else if(nums.length <= idx){
           return;
       }else{
           int plus = nums[idx];
           findTargetHelper(nums,idx + 1, target - plus);
           findTargetHelper(nums,idx + 1, target + plus);
       }
    }
    
}
