package leet_code.java;

import java.util.Arrays;

public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        int size = 100001;
        int[] occuranceCounter = new int[size];
        for(int i = 0; i < arr.length; i++){
            occuranceCounter[arr[i]] = occuranceCounter[arr[i]] + 1;
        }
        Arrays.sort(occuranceCounter);
        int removedSofar = 0;
        for(int i = occuranceCounter.length - 1; i >= 0; i--){
            removedSofar += occuranceCounter[i];
            if(removedSofar >= arr.length/2){
                return (occuranceCounter.length) - i;
            }
            
        }
        return 1;
        
    }


    public static void main(String[] args){
        ReduceArraySizeToTheHalf reduceArraySizeToTheHalf = new ReduceArraySizeToTheHalf();
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        int minSetSize = reduceArraySizeToTheHalf.minSetSize(arr);
        System.out.println("result: " + minSetSize);
    }
    
}
