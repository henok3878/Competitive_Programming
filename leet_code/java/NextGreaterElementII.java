package leet_code.java;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {


    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                 ans[stack.pop()] = nums[i];    
            }
            stack.push(i);
        }
       
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                 ans[stack.pop()] = nums[i];    
            }
        }

        return ans;
    }
    
    
}
