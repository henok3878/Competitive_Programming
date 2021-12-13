package leet_code.java;

import java.util.ArrayList;
import java.util.List;

import leet_code.java.util.Utility;

public class MergeIntervals {


    public int[][] merge(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
        
        List<ArrayList<Integer>>  mergedIntervals = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < intervals.length; i++){
            int[] currentInterval = intervals[i];
            if(!mergedIntervals.isEmpty()){
                ArrayList<Integer> lastMergedInterval = mergedIntervals.get(mergedIntervals.size()-1);
                if(currentInterval[0] <= lastMergedInterval.get(1)){
                    if(currentInterval[1] > lastMergedInterval.get(1)){
                       lastMergedInterval.set(1, currentInterval[1]);
                    }
                        continue;
                    
                }
            }
            int st = currentInterval[0];
            int end = currentInterval[1];
            ArrayList<Integer> interval = new ArrayList<Integer>();
            interval.add(st);interval.add(end);
            mergedIntervals.add(interval);
           
        }
        int[][] result = new int[mergedIntervals.size()][2];
        for(int i = 0; i < mergedIntervals.size() ; i++){
            ArrayList<Integer> interval = mergedIntervals.get(i);
            int[] inter = {interval.get(0),interval.get(1)};
            result[i] = inter;

        }
        return result;
    }
    static void swap(int[][] arr, int i, int j)
{
    int[] temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
  
 int partition(int[][] arr, int low, int high)
{
      
    // pivot
    int pivot = arr[high][0]; 
    int i = (low - 1); 
  
    for(int j = low; j <= high - 1; j++)
    {
    
        if (arr[j][0] < pivot) 
        {
              
            i++; 
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
}

 void quickSort(int[][] arr, int low, int high)
{
    if (low < high) 
    {
          

        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
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
