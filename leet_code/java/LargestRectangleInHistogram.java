package leet_code.java;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int[][] indexOfMinInBothSides = new int[heights.length][2];
        stack.push(0);
        int idx;
        int pop;
        for(int i =1 ; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                idx = stack.pop();
                pop = heights[idx];
                indexOfMinInBothSides[idx] = new int[]{0,i-1};
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            indexOfMinInBothSides[stack.pop()] = new int[]{0,heights.length-1};
        } 
        

        stack.push(heights.length - 1);
        int[] prev = new int[2];
        for(int i = heights.length - 2; i >= 0; i--){
             while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                idx = stack.pop();
                pop = heights[idx];
                prev = indexOfMinInBothSides[idx]; 
                prev[0] = i;
                indexOfMinInBothSides[idx] = prev;
            }
            stack.push(i);
            
        }
        while(!stack.isEmpty()){
              idx = stack.pop();
              prev = indexOfMinInBothSides[idx]; 
              prev[0] = -1;
              indexOfMinInBothSides[idx] = prev;       
        }
        int ans = 0;
        for(int i = 0; i < indexOfMinInBothSides.length ; i++){
            prev = indexOfMinInBothSides[i];
            ans = Math.max(ans,(prev[1] - prev[0]) *heights[i]);
        }
        return ans;
    }
    
}
