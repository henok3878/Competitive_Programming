package leet_code.java;

public class  MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int i = 0, j = 1;
        while(j < nums.length){
            if(nums[i] == 0) {
                if(nums[j] == nums[i]){
                    j++;
                }
                else{
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }
            }
            else{
                i++;
                j++;
            }
        }
        
    }
}
