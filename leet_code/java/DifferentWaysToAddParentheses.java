package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    
    public List<Integer> diffWaysToCompute(String expression) {   
         
        List<Integer> ans = new ArrayList<Integer>();
        if(expression.length() == 1){
            ans.add(expression.charAt(0) -'0');
            return ans;
        }
        else{     
            for(int i = 0; i < expression.length(); i++){    
                char curr = expression.charAt(i);
                if(curr == '*' || curr == '-' || curr == '+'){
                      List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                      List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                      for(int l : left){
                          for(int r : right){
                              ans.add(calculate(l,r,curr));
                          }
                      }
                }
            }
            if(ans.size() == 0){
               ans.add(Integer.parseInt(expression));
            }
        }
        
        return ans;   
    }
    
    public int calculate(int l , int r, char op){
        switch(op){
            case '+':
                return l+r;
            case '-':
                return l - r;
            case '*':
                return l*r;
            default: 
                return -1;
        }
    }
    
}
