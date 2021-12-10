package hacker_rank.java;

import java.util.Arrays;
import java.util.List;

public class InsertionSort1 {

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
            for(int i = arr.size() - 1; i > 0; i--){
                int j = i;
                int currElem = arr.get(j);
                while(j > 0 && currElem < arr.get(j-1)){
                    arr.set(j, arr.get(j-1));
                    printArray(arr);
                    j--;
                }
                arr.set(j, currElem);
            }
            printArray(arr);
    }

    public static void printArray(List<Integer> arr){
        for(int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        InsertionSort1.insertionSort1(5, Arrays.asList(2,4,6,8,3));
    }


    
}
