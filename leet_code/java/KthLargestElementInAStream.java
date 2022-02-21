package leet_code.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    class KthLargest {
        int k;
        int[] nums;
        Queue<Integer> pq;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for(int num : nums) pq.add(num);
            while(pq.size() > k) pq.poll();
        }
        
        public int add(int val) {
            pq.add(val);
            if(pq.size() > k) pq.poll();
            return pq.peek();
        }
    }
}
