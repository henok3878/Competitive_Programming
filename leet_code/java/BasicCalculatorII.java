package leet_code.java;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        int ans=0;
        Stack<Integer> stack = new Stack<>();
        int l = s.length();
        Character currOp = '+', currChar;
        int currNum = 0;
        
        for(int i = 0;i<l;i++){
            currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                currNum = currNum*10 +(currChar - '0');
            } if( !Character.isDigit(currChar) && !(currChar == ' ') || i==l-1){
                if(currOp == '+'){
                    stack.push(currNum);
                } else if(currOp == '-'){
                    stack.push(currNum*-1);
                } else if(currOp == '*'){
                    stack.push(currNum*stack.pop());
                } else if(currOp == '/'){
                    stack.push(stack.pop()/currNum);
                }
                currOp = currChar;
                currNum = 0;
            }
        }
        while(stack.size()>0){
            ans = ans + stack.pop();
        }
        
		return ans;
    }
    
}
