package leet_code.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays{
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int queriesLength = l.length;
        List<Boolean> answer = new ArrayList<Boolean>();
        
        for(int i = 0; i < queriesLength; i++){
            int stIndex = l[i];
            int endIndex = r[i]; 
            int currentRangeLength = endIndex - stIndex + 1;
            int[] currentSubArray = new int[currentRangeLength];
            boolean addCurrentRange = true;
            int currentSubArrayIndex = 0;
            for(int index = stIndex; index <= endIndex; index++){
                currentSubArray[currentSubArrayIndex] = nums[index];
                currentSubArrayIndex++;                
            }
            Arrays.sort(currentSubArray);
            int step = currentSubArray[1] - currentSubArray[0];
            for(int j = 1; j < currentRangeLength - 1; j++){
                if(step != (currentSubArray[j+1] - currentSubArray[j])){
                    addCurrentRange = false;
                    break;
                }
                
            }
            answer.add(addCurrentRange);
        }
        
        
        return answer;
    }


    public static void main(String[] args){
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};

        ArithmeticSubarrays arithmeticSubarrays = new ArithmeticSubarrays();
        List<Boolean> result = arithmeticSubarrays.checkArithmeticSubarrays(nums, l, r);
        System.out.println(result);


    }

}