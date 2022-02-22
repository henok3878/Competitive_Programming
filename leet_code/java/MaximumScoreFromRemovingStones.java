package leet_code.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {
        Queue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2 - o1);
        pq.add(a); pq.add(b); pq.add(c);
        int point = 0;
        while(pq.size() > 1){
            int first = pq.poll() - 1;
            int second = pq.poll() - 1;
            if(first > 0) pq.add(first);
            if(second > 0) pq.add(second);
            point++;
        }
        return point;
        
    }
}
