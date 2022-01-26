package leet_code.java;

public class TwoSumIIInputArrayIsSorted {
    
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int diff = target - numbers[i];
            int diffIdx = findNum(numbers,diff, i + 1);
            if(diffIdx != -1){
                ans[0] = i + 1;
                ans[1] = diffIdx + 1;
                return ans;
            }
        }
        return ans;
    }
    
    private int findNum(int[] nums, int num, int s){
        int st = s;
        int end = nums.length - 1;
        while(st <= end){
            int mid = (st + end) / 2;
            if(nums[mid] > num){
                end = mid - 1;
            }
            else if(nums[mid] < num){
                st = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
