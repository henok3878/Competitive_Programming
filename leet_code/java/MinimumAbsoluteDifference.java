package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            int diff = arr[i] - arr[i-1];
            if(diff < minDiff){
                minDiff = diff;
                ans.clear();
                ans.add(new ArrayList(Arrays.asList(arr[i-1],arr[i])));
            }
            else if(diff == minDiff){
                ans.add(new ArrayList(Arrays.asList(arr[i-1],arr[i])));
            }
        }
        return ans;
    }

    public static void main(String[] args){
        
    }
}
