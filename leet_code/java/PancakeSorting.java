package leet_code.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PancakeSorting{


    public List<Integer> pancakeSort(int[] arr) {
        HashMap<Integer,Integer> numToIndex = new HashMap();
        List<Integer> ans = new ArrayList();
        for(int i = 0; i < arr.length; i++){
            numToIndex.put(arr[i],i);
        }
        int currLargestIndex = arr.length - 1;
        for(int i = arr.length; i >= 0; i--){
            if(numToIndex.containsKey(i)){
                int indexOfLargest= numToIndex.get(i);
                if(indexOfLargest > 0){
                    for(int key : numToIndex.keySet()){
                         if(numToIndex.get(key) <= indexOfLargest){
                         numToIndex.put(key,indexOfLargest - numToIndex.get(key));
                     }
                }
                ans.add(indexOfLargest + 1);
            }    
            for(int key: numToIndex.keySet()){
                  if(numToIndex.get(key) <= currLargestIndex){
                    numToIndex.put(key,currLargestIndex - numToIndex.get(key));
                  }
            }
             ans.add(currLargestIndex + 1);
                  currLargestIndex--;
                
            }    
          
        }
        
        return ans;
    
    }

    public static void mian(String[] args){


    }
}