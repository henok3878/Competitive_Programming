package leet_code.java;

public class BinarySubarraysWithSum {


    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        if ( goal == 0 ) return helper(nums);
        
        int prevLeft = -1;
        int left = 0,right = 0;
        int sum = 0;
        int count = 0;
        // deal with S > 0 but cases like[0,0,0,0,0]
        while ( left < nums.length && nums[left] == 0 ) {
            left++;
            right++;
        }
        
        //   formuala : ans += (leftZeros + 1) => leftZeros = (left - prevLeft) 
        //   ans += (left - prevLeft) + 1
        
        while ( right < nums.length ) {
            if ( sum + nums[right] == goal ) {
                sum += nums[right];
                count += 1 + (left - prevLeft - 1);
                right++;
            }
            else if ( sum + nums[right] < goal ) {
                sum += nums[right];
                right++;
            }
            else {
                sum -= nums[left];
                prevLeft = left;
                left++;
                while ( nums[left] == 0 ) 
                    left++;
            }
        }
        return count;
    }
    
    public int helper(int[] nums) {
        int count = 0;
        int res = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            if ( nums[i] == 0 ) {
                count++;
                res += count;
            }
            else {
                count = 0;
            }
        }
        return res;
    }
    
}
