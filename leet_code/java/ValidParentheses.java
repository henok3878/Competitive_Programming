package leet_code.java;

import java.util.Stack;

public class ValidParentheses {
    
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) return false;
          Stack<Character> stack = new Stack<Character>();
          for(int i = 0; i < s.length(); i++){
              char currentChar = s.charAt(i);
              if(isOpening(currentChar)){
                  stack.push(currentChar);
              }else{
                  if(stack.isEmpty()){
                      return false;
                  }
                   char currentCharInStack = stack.pop();
                   if(!areCompl(currentCharInStack,currentChar)){
                       return false;
                   }
              }
          }
          if(!stack.isEmpty()){
              return false;
          }
          return true;
       }
   
       public boolean isOpening(char c){
           if(c == '(' || c == '[' || c == '{'){
               return true;
           }
           return false;
       }
       public boolean areCompl(char openingChar, char closingChar){
           if(openingChar == '(' && closingChar == ')' || openingChar == '[' && closingChar == ']' || openingChar == '{' && closingChar == '}'){
               return true;
   
           }
           return false; 
       }


    public static void main(String[] args){
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "()[]{}";
       boolean result = validParentheses.isValid(s);
       System.out.println(" Result: " + result);


    }
    
}
