package leet_code.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE;
        Queue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] %  2 != 0) nums[i] *= 2; 
            min = Math.min(min,nums[i]);
            pq.add(nums[i]);
        }
        int ans = Integer.MAX_VALUE;
        
        while(pq.peek() % 2 == 0){
            int pop = pq.poll();
            ans = Math.min(ans,pop - min);
            pop /= 2;
            pq.add(pop);
            min = Math.min(min, pop);
        }
        ans = Math.min(ans,pq.peek() - min);
        return ans;
    } 
}
