package leet_code.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int totalBricks = 0;
        int totalJumps = 0;
        int n = heights.length;
        Queue<Building> maxHeap = new PriorityQueue<>((a,b) -> (b.bricksReq == a.bricksReq) ? b.location - a.location : b.bricksReq - a.bricksReq);
        for(int i = 0; i < n; i++){
            int right = (i + 1 < n) ? i + 1 : i;
            int diff = heights[right] - heights[i];
            if(diff > 0){
                totalBricks += diff;
                totalJumps++;
                Building nb = new Building(totalBricks,right);
                maxHeap.add(nb);
            }
        }
        
        int idx =  maxHeap.peek().location;
        boolean isFound = false;
        while(totalJumps > 0){
            int jumpsUsingBricks = totalJumps - ladders;
            while(maxHeap.size() > jumpsUsingBricks){
                if(maxHeap.peek().bricksReq <= bricks){
                    idx = maxHeap.poll().location;
                    isFound = true;
                    break;
                }
                maxHeap.poll();
            }
            if(isFound) break;
            totalJumps--;
            
        }
        int right = (idx + 1 < n) ? idx + 1 : idx;
        while(right < n && heights[right] - heights[idx] <= 0){
            idx++;
            right++;
        }
        return idx;
        
    }
}
class Building{
    int bricksReq;
    int location;    
    public Building(int req, int loc){
        bricksReq = req;
        location = loc;
    }
    
    public String toString(){
        return location + "," + bricksReq;
    }
    
}