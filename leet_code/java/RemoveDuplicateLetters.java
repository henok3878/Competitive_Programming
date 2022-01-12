package leet_code.java;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        
        for(int i =0; i < s.length() ; i++)
            count[s.charAt(i) - 'a']++;
        
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'a';
            count[curr]--;
            if(visited[curr])continue;
            while(!stack.isEmpty() && count[stack.peek()] >  0 && stack.peek() > curr){
                int pop = stack.pop();
                visited[pop] = false;              
            }
            stack.push(curr);
            visited[curr] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int pop = stack.pop();
            char c = (char)(pop + 'a');
            sb.append(c);    
        }
        
       return sb.reverse().toString();
    }
    
}
