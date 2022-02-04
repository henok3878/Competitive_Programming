package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap();
        int sum = 0, ans = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0) ? -1 : 1;
            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }
            else  map.put(sum,i);
        }
        
        return ans;
    }
    
}
