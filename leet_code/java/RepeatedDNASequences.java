package leet_code.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> ans = new ArrayList();
        Map<String,Boolean> visited = new HashMap();
        for(int i = 0; i <= s.length() - 10; i++){
            String curr = s.substring(i,i+10);
            if(visited.containsKey(curr)){
                if(visited.get(curr) != false){
                    visited.put(curr,false);
                    ans.add(curr);
                }
            }
            else visited.put(curr,true);            
        }
        return ans;
    }
}
