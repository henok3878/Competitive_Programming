package leet_code.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int res = 0;
        // O(n)
        for(int pile : piles){ 
            pq.add(pile);
            res += pile;
        }
        // O(klog(n))
        while(!pq.isEmpty() && k > 0){ // loops k times 
            int pile = pq.poll();
            res -= (pile / 2);
            pq.add(pile - (pile/2)); // log(n)
            k--;
        }
        
        return res;
        
    }
}
