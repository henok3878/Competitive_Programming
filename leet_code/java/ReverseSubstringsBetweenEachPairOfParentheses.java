package leet_code.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(currentChar != ')'){
                stack.push(currentChar);
            }
            else{
                char top = stack.pop();
                Queue<Character> tempStack = new LinkedList();
                while(top != '('){
                    tempStack.add(top);
                    top = stack.pop();
                }
                while(!tempStack.isEmpty()){
                    stack.push(tempStack.remove());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
    
}
