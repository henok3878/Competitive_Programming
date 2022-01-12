package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {


    public List<String> letterCombinations(String digits) {
        Map<Character,List<String>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList("a","b","c")));
        map.put('3',new ArrayList<>(Arrays.asList("d","e","f")));
        map.put('4',new ArrayList<>(Arrays.asList("g","h","i")));
        map.put('5',new ArrayList<>(Arrays.asList("j","k","l")));
        map.put('6',new ArrayList<>(Arrays.asList("m","n","o")));
        map.put('7',new ArrayList<>(Arrays.asList("p","q","r","s")));
        map.put('8',new ArrayList<>(Arrays.asList("t","u","v")));
        map.put('9',new ArrayList<>(Arrays.asList("w","x","y","z")));
        
        
        return letterCmbinationsHelper(digits,map);        
    }
    
    private List<String> letterCmbinationsHelper(String digits, Map<Character,List<String>> map){
        List<String> ans = new ArrayList<>();
        if(digits.length() == 1){
            ans = map.get(digits.charAt(0));
        }else if(digits.length() > 1){
            List<String> firstDigits = letterCmbinationsHelper(digits.substring(0,1),map);
            List<String> restDigits = letterCmbinationsHelper(digits.substring(1),map);
            for(String f : firstDigits){
                for(String r : restDigits){
                    ans.add(f+r);
                }
            }
        }
        return ans;   
    }
    
}
