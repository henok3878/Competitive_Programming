package leet_code.java;

import java.util.Stack;

public class DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack();
        int[] ans = new int[temperatures.length];
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                ans[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);        
        }
        return ans;
        
    }


    public static void main(String[] args){
        
    }
    
}
