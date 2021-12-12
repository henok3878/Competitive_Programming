package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        Map<String,Boolean> visited = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
                sum += nums[i];
        }
        if(sum%2 != 0){
            return false;
        }
        else{
            return canPartitionHelper(visited,nums, sum/2, 0, 0);
        }
    }

    public boolean canPartitionHelper(Map<String,Boolean> visited,int[] nums,int halfSum, int index, int sumSofar){
        String currentState = index+""+sumSofar;
        if(visited.containsKey(currentState)){
            return visited.get(currentState);
        }
       
        if(sumSofar == halfSum){
            return true;
        }
        if(sumSofar > halfSum || index == nums.length){
            return false;
        }
        boolean result = false;
        if(index + 1 < nums.length){
            result =  canPartitionHelper(visited,nums,halfSum,index + 1 ,sumSofar + nums[index]) || canPartitionHelper(visited,nums, halfSum, index + 1, sumSofar);
        }
        visited.put(currentState, result);
        return result;
    }


    public static void main(String[] args){
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        //int[] nums = {1,2,5};
        long start =  System.currentTimeMillis();
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        boolean result = partitionEqualSubsetSum.canPartition(nums);
        long end = System.currentTimeMillis();
        System.out.println("diff: " + (end-start));
        System.out.println(result);
    }
    
}
