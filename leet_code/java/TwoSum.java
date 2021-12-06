package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class TwoSum{

    public int[] solution(int[] nums, int target) {
        
        
        Map<Integer,Integer> visitedNumbers = new HashMap();
        int[] result = new int[2];
        for(int i = 0; i < nums.length ; i++){
            int complimentNumber = target - nums[i];
            if(visitedNumbers.containsKey(complimentNumber)){
                result[0] = i;
                result[1] = visitedNumbers.get(complimentNumber);
                break;

                
            }else{
                visitedNumbers.put(nums[i],i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums =  {2,7,11,15};
        int target = 9;
       int[] result =  new TwoSum().solution(nums, target);
        
        System.out.println("Result " + result[0] + ", "+result[1]);
    }

}