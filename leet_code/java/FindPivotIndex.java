package leet_code.java;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
          
            if(sum - ((2*currSum) + nums[i]) == 0) return i;
            
            currSum += nums[i];
        }
        return -1;
    }
}
