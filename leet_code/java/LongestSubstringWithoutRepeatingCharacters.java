package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        // "abcabcbb"
        Map<Character,Integer> chars = new HashMap();
        int i = 0, j = 0, longest = 0;
        while(j < s.length() && i <= j){
            char curr = s.charAt(j);
            if(chars.containsKey(curr) && chars.get(curr) > -1)
                i = Math.max(i,chars.get(s.charAt(j))+1);
            chars.put(curr,j);
            longest = Math.max(longest,j - i + 1);
            j++;
        }
        return longest;   
    }
}
