package leet_code.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        
        Map<Character,String> map = new HashMap();
        Set<String> visited = new HashSet();
        
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char  c = pattern.charAt(i);
            if(!map.containsKey(c)){
                if(visited.contains(words[i])){
                    return false;
                }
                map.put(c,words[i]);
                visited.add(words[i]);
            }else{
                String prevWord = map.get(c);
                if(!prevWord.equals(words[i])){
                    return false;
                }
            }
        }
        return true;
        
    }
    
}
