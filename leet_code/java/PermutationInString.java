package leet_code.java;

import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int windowSize = s1.length();
        int right = windowSize;
        int[] s1Arr = new int[26];
        countLetters(s1,s1Arr);
        int[] winArr = new int[26];
        countLetters(s2.substring(0,right),winArr);
        for(int i = 0; i <= s2.length() - windowSize ; i++){
            right = i + windowSize;
            if(Arrays.equals(s1Arr,winArr)) return true;
            if(right >= s2.length()) continue;
            winArr[s2.charAt(i) - 'a']--;
            winArr[s2.charAt(right) - 'a']++;
        }
        return false;
        
    }
    
    
    private void countLetters(String s, int[] arr){
        for(int i = 0;i < s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }
    }
    
}
