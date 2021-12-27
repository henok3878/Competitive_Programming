package leet_code.java;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> stack = new Stack();
        int currPoppedIdx = 0;  
        for(int currPushedIdx = 0; currPushedIdx < pushed.length ; currPushedIdx++){
            while(!stack.isEmpty() &&  stack.peek() == popped[currPoppedIdx]){
                stack.pop();
                currPoppedIdx++;
            }
            stack.push(pushed[currPushedIdx]);
        }
        
        while(!stack.isEmpty() && stack.peek() == popped[currPoppedIdx]){
                stack.pop();
                currPoppedIdx++;
        }
        return stack.isEmpty();
    }
    
}
