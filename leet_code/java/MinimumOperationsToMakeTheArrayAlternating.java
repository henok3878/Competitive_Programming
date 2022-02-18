package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToMakeTheArrayAlternating {
    public int minimumOperations(int[] nums) {
        Map<Integer,Integer> evens = new HashMap<>();
        evens.put(0,0);
        Map<Integer,Integer> odds = new HashMap<>();
        odds.put(0,0);
        int oddMax1 = 0, oddMax2 = 0, evenMax1 = 0, evenMax2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                // even 
                int freq = evens.getOrDefault(nums[i], 0);
                freq += 1;
                evens.put(nums[i],freq);
                if(evenMax1 != nums[i]){
                    if(freq >= evens.get(evenMax1)){
                        evenMax2 = evenMax1;
                        evenMax1 = nums[i];
                    }else if(freq >= evens.get(evenMax2)) evenMax2 = nums[i];
                }
                
            }else{
                // odd 
                int freq = odds.getOrDefault(nums[i], 0);
                freq += 1;
                odds.put(nums[i],freq);
                if(oddMax1 != nums[i]){
                    if(freq >= odds.get(oddMax1)){
                        oddMax2 = oddMax1;
                        oddMax1 = nums[i];
                    }else if(freq >= odds.get(oddMax2)) oddMax2 = nums[i];
                }
            }
        }
        int res = odds.get(oddMax1) + evens.get(evenMax1);
        if(oddMax1 == evenMax1){
            res = Math.max(odds.get(oddMax2) + evens.get(evenMax1),odds.get(oddMax1) + evens.get(evenMax2));
        }
        return (nums.length - res);
       
    }
}
