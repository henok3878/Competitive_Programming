package hacker_rank.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort1 {

    public static List<Integer> countingSort(List<Integer> arr) {
        //int[] initArr = new int[100];
        Integer[] numbers = new Integer[10];
        Arrays.fill(numbers,0);
        List<Integer> tempArray = Arrays.asList(numbers);
        
        for(int i = 0; i < arr.size() ; i++){
            int elem = arr.get(i);
            int prevValue = tempArray.get(elem);
            tempArray.set(elem, prevValue + 1);
        }
        
        return tempArray; // todo 
    }

    public static void printArray(List<Integer> arr){
        for(int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        List<Integer> result = CountingSort1.countingSort(Arrays.asList(2,4,6,8,3));
        printArray(result);
    }
    
}
