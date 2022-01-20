package leet_code.java;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<Integer>();
        
        for(int num : nums){
            if(visited.contains(num)){
                return true;
            }
            visited.add(num);
        }
        return false;
    }

}
