package leet_code.java;

import java.util.ArrayList;
import java.util.List;

import leet_code.java.util.Utility;

public class FindTargetIndicesAfterSorting {
    public List<Integer> targetIndices(int[] nums, int target) {
        int size = 101;
        List<Integer> targetIndices = new ArrayList<>();
        int[] counts = new int[size];
        int[] modifiedCounts = new int[size];

        for(int i = 0; i < nums.length ; i++){
            int currentNum = nums[i];
            counts[currentNum] = counts[currentNum] + 1;
            modifiedCounts[currentNum] = modifiedCounts[currentNum] + 1;
        }
        for(int i = 1; i < counts.length ; i++){
            modifiedCounts[i] = modifiedCounts[i] + modifiedCounts[i-1];
        }
        int numOfOccurance = counts[target];
        int startingIndex = modifiedCounts[target] - numOfOccurance;
        for(int i = startingIndex; i < startingIndex + numOfOccurance; i ++){
            targetIndices.add(i);
        }
        
        return targetIndices;
    }
    
    public static void main(String[] args){
        FindTargetIndicesAfterSorting findTargetIndicesAfterSorting = new FindTargetIndicesAfterSorting();
        int[] nums = {1,2,5,2,3};
        int target = 2;
        List<Integer> result = findTargetIndicesAfterSorting.targetIndices(nums, target);
        System.out.println("Result : " + result);
    }
    
}
