package leet_code.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Boolean> isPalindrome = new HashMap<>();
        isPalindrome.put("",true);
        helper(isPalindrome,s,0,s.length(),ans,new ArrayList<>());
        
        return ans;
    }
    
    // st: start index, end: ending index not inclusive 
    private void helper(Map<String,Boolean> isPalindrome, String s, int st, int end, List<List<String>> ans, List<String> curr){
        
      if(st >= end){
          ans.add(new ArrayList<>(curr));
          return;
      }  
      for(int i = st; i < end; i++){
          if(isPali(isPalindrome, s,st,i + 1)){
               curr.add(s.substring(st,i + 1)); 
               helper(isPalindrome, s,i + 1,end,ans,curr);
               curr.remove(curr.size() - 1);
          }
         
      }  
        
    } 
    
    private boolean isPali(Map<String,Boolean> isPalindrome, String s, int i, int j){
        if(i >= j){
            return true;
        }
        String key = s.substring(i,j);
        if(isPalindrome.containsKey(key)) return isPalindrome.get(key);
        else if(s.charAt(i) == s.charAt(j-1)) return isPali(isPalindrome,s,i + 1, j - 1);
        
        isPalindrome.put(key,false);
        return false;
    }
}
