package leet_code.java;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int right = -1;
        int left = nums.length;
        int maxSofar = Integer.MIN_VALUE;
        int minSofar = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length ; i++){
            int currentNum = nums[i];
            if(currentNum < maxSofar){
                right = i;
            }
            if(currentNum > maxSofar){
                maxSofar = currentNum;
            }
            
        }
        for(int j = nums.length -1 ; j >= 0; j--){
            int currentNum = nums[j];
            if(currentNum > minSofar){
                left = j;
            }
            if(currentNum < minSofar){
                minSofar = currentNum;
            }
        }
        if(right == -1 && left == nums.length){
            return 0;
        }
        return right - left + 1;
    }

    public static void main(String[] args){
        

    }
    
}
