package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leet_code.java.util.Utility;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        List<List<Integer>> merged = new ArrayList();
        merged.add(new ArrayList(Arrays.asList(intervals[0][0],intervals[0][1])));
        for(int[] interval : intervals){
            List<Integer> top = merged.get(merged.size() - 1);   
            if(interval[0] > top.get(1)){
                merged.add(new ArrayList(Arrays.asList(interval[0],interval[1])));
            }else if(interval[1] > top.get(1)){
                top.set(1,interval[1]);
                merged.set(merged.size() - 1, top);
            } 
        }
        int[][] ans = new int[merged.size()][2];        
        for(int i = 0; i < merged.size(); i++){
            ans[i] = new int[]{merged.get(i).get(0),merged.get(i).get(1)};
        }
        return ans;
    }


    public static void main(String[] args){
            MergeIntervals mergeIntervals = new MergeIntervals();
            //[[2,3],[4,5],[6,7],[8,9],[1,10]]
            //int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
           int[][] intervals = {{1,4},{0,0}};
            int[][] result = mergeIntervals.merge(intervals);
            for(int i = 0; i < result.length ; i ++){
                Utility.printArray(result[i]);
            }

    }
}
