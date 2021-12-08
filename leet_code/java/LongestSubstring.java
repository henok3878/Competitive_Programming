package leet_code.java;

import java.util.HashSet;
import java.util.Set;


public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int currIndex = 0;
        int finalIndex = currIndex;
        String temp = "";
        String longestSubstring = "";
        Set<Character> visitedChars = new HashSet<>();
        while(currIndex < s.length()){
            char currChar = s.charAt(finalIndex);
            if(visitedChars.contains(currChar)){
                    if(longestSubstring.length() < temp.length()){
                        longestSubstring = temp;
                    }
                    currIndex++;
                    finalIndex = currIndex;
                    temp = "";
                    visitedChars.clear();


            }else{
                visitedChars.add(currChar);
                temp += currChar;
                if(finalIndex < s.length() - 1){
                    finalIndex++;
                }else{
                    if(temp.length() > longestSubstring.length()){
                        longestSubstring = temp;
                        currIndex++;
                        finalIndex = currIndex;
                        temp = "";
                        visitedChars.clear();
                    }
                }
            }
            


        }
        return longestSubstring.length();
        
    }


    public static void main(String[] args) {

        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println("Result: " + longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        
    }
    
}
