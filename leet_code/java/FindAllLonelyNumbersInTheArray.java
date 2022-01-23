package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllLonelyNumbersInTheArray {
    
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> ans = new ArrayList();
        
        int[] counts = new int[1000001];
        for(int num : nums){
            counts[num]++;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(counts[nums[i]] == 1){
                if((i-1) >= 0 && (nums[i-1] == nums[i] - 1)){
                       continue;
                }
                else if((i + 1) < nums.length && nums[i+1] == nums[i] + 1){
                    continue;
                }
                ans.add(nums[i]);
            }
          
        }
        
        return ans;
    }

}
