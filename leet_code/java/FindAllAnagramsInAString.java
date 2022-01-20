package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList();
        if(p.length() > s.length() ) return ans;

        int windowSize = p.length();
        int right = windowSize;
        int[] pArr = new int[26];
        int[] currArr = new int[26];
        countLetters(p,pArr); 
        countLetters(s.substring(0,right),currArr);

        for(int i = 0; i <= s.length()- windowSize; i++){
            right = i + windowSize;
            if(Arrays.equals(currArr,pArr)) ans.add(i);
            if(right >= s.length()){continue;}
            currArr[s.charAt(i) - 'a']--;
            currArr[s.charAt(right) - 'a']++;
        }
        return ans;
    }
    
    private void countLetters(String p, int[] pArr){
        for(int i = 0; i < p.length() ; i++){
            pArr[p.charAt(i) - 'a']++;
        }
    }
}
