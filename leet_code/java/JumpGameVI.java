package leet_code.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        int[] results = new int[nums.length];
        
        Deque<Integer> mq = new ArrayDeque();
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(!mq.isEmpty() && mq.peekFirst() - i > k){
                mq.pollFirst();
            }
            int prevMax = mq.isEmpty() ? 0 : results[mq.peekFirst()];
            results[i] = prevMax + nums[i];
            while(!mq.isEmpty() && results[mq.peekLast()] < results[i]){
                mq.pollLast();
            }  
            mq.add(i);
           
        }
        return results[0];   
    }
    
}
