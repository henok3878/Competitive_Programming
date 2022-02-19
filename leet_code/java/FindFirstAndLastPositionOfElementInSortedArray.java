package leet_code.java;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 1) return new int[]{-1,-1};
        int st = 0; int end = nums.length - 1;
        int mid = 0;
        while(st <= end){
            mid = ( st + end)/2;
            if(nums[mid] > target) end = mid - 1;
            else if(nums[mid] < target) st = mid + 1;
            else break;
        }
        if(nums[mid] != target){
            return  new int[]{-1,-1};
        }else{
            int i = mid, j = mid;
            while(i >= 0 && nums[i] == target) i--;
            while(j < nums.length && nums[j] == target) j++;
            return new int[]{i + 1, j - 1};
        }
    }
}
