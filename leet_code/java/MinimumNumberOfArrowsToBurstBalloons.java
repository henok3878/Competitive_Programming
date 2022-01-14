package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points,(a,b)->(a[0]%1000000007) - (b[0]%1000000007));
        Stack<List<Integer>> stack = new Stack();
        for(int i = 0; i < points.length; i++){
            List<Integer> currInterval = new ArrayList(Arrays.asList(points[i][0],points[i][1]));
            if(!stack.isEmpty()){
                List<Integer> recentInterval = stack.peek();
                if(currInterval.get(0) <= recentInterval.get(1)){
                    int st = Math.max(currInterval.get(0),recentInterval.get(0));
                    int end = Math.min(currInterval.get(1),recentInterval.get(1));
                    currInterval = new ArrayList(Arrays.asList(st,end));
                    stack.pop();
                }
            }
            stack.push(currInterval);
            
        }
        return stack.size();
        
    }
    
}
