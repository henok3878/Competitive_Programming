package leet_code.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import leet_code.java.util.Utility;

public class FindOriginalArrayFromDoubledArray {
   
   
    public int[] findOriginalArray(int[] changed) { 
        int[] emptyArray = {};
        if(changed.length % 2 != 0){
            return emptyArray;

        }
        Arrays.sort(changed);
        int[] ans = new int[changed.length/2];
        int filledIndex = 0;
        Map<Integer, Integer> visitedDoublesCount = new HashMap<>();

        for(int i = changed.length - 1; i >= 0; i--){
            int doubledNum = 2 * changed[i];
            if(visitedDoublesCount.containsKey(doubledNum)){
                int prevValue = visitedDoublesCount.get(doubledNum);
                if(prevValue > 0){
                    ans[filledIndex] = changed[i];
                    visitedDoublesCount.put(doubledNum, prevValue - 1);
                    filledIndex++;
                }else{
                    if(visitedDoublesCount.containsKey(changed[i])){
                        int val = visitedDoublesCount.get(changed[i]);
                        visitedDoublesCount.put(changed[i], val + 1);
                    }else{
                      if(changed[i] % 2 == 0){
                        visitedDoublesCount.put(changed[i], 1);
                      }

                    }
                }
            }
            else{
                 
              if(changed[i]%2 == 0){
                if(visitedDoublesCount.containsKey(changed[i])){
                    int prevValue = visitedDoublesCount.get(changed[i]);
                    visitedDoublesCount.put(changed[i], prevValue + 1);
                }else{
                    visitedDoublesCount.put(changed[i], 1);

                }
              }

            }
        }
        if(filledIndex == changed.length/2){
            return ans;
        }else{

            return emptyArray;
        }        
    }


    public static void main(String[] args){
        //int[] changed = {1,3,4,2,6,8};
        //int[] changed = {6,3,0,1};
        int[] changed = {0,0,0,0};
        FindOriginalArrayFromDoubledArray findOriginalArrayFromDoubledArray = new FindOriginalArrayFromDoubledArray();
       int[] ans =  findOriginalArrayFromDoubledArray.findOriginalArray(changed);
       System.out.println("Ans");
       Utility.printArray(ans);
    }
    
}
