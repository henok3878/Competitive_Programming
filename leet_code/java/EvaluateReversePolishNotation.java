package leet_code.java;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length; i++){
            String currentChar = tokens[i];
            if(!currentChar.equals("+") && !currentChar.equals("-") && !currentChar.equals("*") && !currentChar.equals("/")){
              stack.push(Integer.parseInt(currentChar));  
            }
            else{
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(compute(currentChar,op1,op2));
            }
        }
        return stack.pop();
        
    }
    
    private int compute(String c, int a, int b)
    {
        switch (c) {  
           case "+": return a+b;
           case "-": return a-b;
           case "*": return a*b;
           case "/": return a/b;
           default: return -1;
        }
    }


    public static void main(String[] args){

        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String[] tokens = {"2","1","+","3","*"};
        int result = evaluateReversePolishNotation.evalRPN(tokens);
        System.out.println("Result: " + result);
    }
    
}
