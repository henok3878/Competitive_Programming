package leet_code.java;

import java.util.HashMap;

public class MaxNumberofKSumPairs {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> occuranceCount = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            occuranceCount.put(nums[i], occuranceCount.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for(int i =0; i < nums.length; i++){
            int target = k - nums[i];
            if(occuranceCount.containsKey(target)){
                int count = occuranceCount.get(target);
                if(count == 1){
                    occuranceCount.remove(target);
                }
                else{
                    occuranceCount.put(target, count - 1);
                }
                int numCount = occuranceCount.get(nums[i]);
                if(numCount == 1){
                    occuranceCount.remove(nums[i]);
                }else{
                    occuranceCount.put(nums[i], numCount-1);
                }
                ans++;

            }
        }
        return ans;
        
    }
    
}
