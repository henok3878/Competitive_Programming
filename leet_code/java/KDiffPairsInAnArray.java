package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        for(int num : nums)    freq.put(num, freq.getOrDefault(num,0) + 1);
        
        int ans = 0;
        for(int num : nums){
            if(freq.get(num) == 0) continue;
            int comp1 = num + k, comp2 = num - k;
            int count1 = freq.getOrDefault(comp1, -1);
            if(k == 0) ans += (count1 > 1) ? 1 : 0;
            else{
                int count2 = freq.getOrDefault(comp2,-1);
                ans += (count1 > 0) ? 1 : 0;
                ans += (count2 > 0) ? 1 : 0;
            }
            freq.put(num,0);
        }    
        return ans;
    }
}
