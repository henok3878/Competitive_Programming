package leet_code.java;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= first) first = num;
            else if(num < second) second = num;
            else if(num > second) return true;
        }
        return false;
    }
}
