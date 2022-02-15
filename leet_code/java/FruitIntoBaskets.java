package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> counts = new HashMap();
        int i =0 , j = 0, max = 0;
        while(j < fruits.length){
            
            if(counts.size() == 2 && !counts.containsKey(fruits[j])){
                while(counts.size() == 2){
                    int freq = counts.get(fruits[i]);
                    if(freq == 1) counts.remove(fruits[i]);
                    else counts.put(fruits[i],freq - 1);
                    i++;
                }
            }
            int prev = counts.getOrDefault(fruits[j],0);
            counts.put(fruits[j], prev + 1);
            max = Math.max(max,j - i + 1);
            j++;
        }
        
        return max;
    }
}
