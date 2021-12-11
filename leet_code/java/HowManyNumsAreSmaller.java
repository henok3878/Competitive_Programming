package leet_code.java;

import leet_code.java.util.Utility;

public class HowManyNumsAreSmaller {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        int[] numOfSmallest = new int[nums.length];
        
        for(int i = 0; i < nums.length ;i++){
            counts[nums[i]] = counts[nums[i]] + 1 ;
        }
        for(int i = 1; i < counts.length ; i++){
            counts[i] = counts[i] + counts[i-1];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 < 0){
                numOfSmallest[i] = 0;
                continue;
            }
            numOfSmallest[i] = counts[nums[i] - 1];
        }
        return numOfSmallest;
    }


    public static void main(String[] args){
        int[] arr = {5,0,10,0,10,6};
        int[] result = new HowManyNumsAreSmaller().smallerNumbersThanCurrent(arr);
        Utility.printArray(result);
    }
    
}
