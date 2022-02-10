package leet_code.java;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap(); // sum to freq 
        map.put(0,1);
        int sum = 0, ans = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)) ans += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return ans;
    }
}
