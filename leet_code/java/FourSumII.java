package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int a : A){
            for(int b : B){
                int prev = map.getOrDefault(a + b, 0);
                map.put(a+b, prev + 1);
            }
        }
        
        int ans = 0;
        for(int c : C){
            for(int d : D){
                //comp = 0 - ( c + d) = -1 * (c + d)
                ans += map.getOrDefault(-1*(c + d),0);
            }
        }
        return ans;
        }
}
