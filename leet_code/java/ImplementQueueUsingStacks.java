package leet_code.java;

import java.util.Stack;

public class ImplementQueueUsingStacks {


    Stack<Integer> stack = new Stack();
    Stack<Integer> tempStack = new Stack();

    public ImplementQueueUsingStacks() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        
    }
    
    public int pop() {
        exchangeStack(stack,tempStack);
        int result =  tempStack.pop();
        exchangeStack(tempStack,stack);
        return result;
        
    }
    
    public int peek() {
          exchangeStack(stack,tempStack);
        int result =  tempStack.peek();
        exchangeStack(tempStack,stack);
        return result;
        
    }
    
    public boolean empty() {
        return stack.isEmpty();
        
    }
    
    private void exchangeStack(Stack stack1, Stack stack2){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }


    public static  void main(String[] args) {
        
    }
    
}
