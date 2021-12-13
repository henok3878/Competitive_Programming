package leet_code;

import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int ans = 0;
        for(int i = 0; i < length ; i+= 2){
            ans += nums[i];
        }
        return ans;
    }
    

    public static void main(String[] args){
        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();
        int[] nums = {6,2,6,5,1,2};
        int result = arrayPartitionI.arrayPairSum(nums);
        System.out.println("Result " + result);
    }
}
