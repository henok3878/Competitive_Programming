package leet_code.java;

public class MaximumLengthOfRepeatedSubarray {
    
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || 
            nums2 == null || nums2.length == 0) return 0;
    
        // slides the nums1 forward [0, nums2.length] units
        int maxLength = 0;
        for (int offset = 0; offset < nums2.length; offset++) {
            maxLength = Math.max(maxLength, slide(nums2, nums1, offset));
        }
        // achieves maximum length possible
        if (maxLength == Math.min(nums1.length, nums2.length)) return maxLength;
    
        // slide nums2 forward [1, nums1.length] units
        for(int offset = 1; offset < nums1.length; offset++){
            maxLength = Math.max(maxLength, slide(nums1, nums2, offset));
        }
    
        return maxLength; 
    }
    
    private int slide(int[] stays, int[] moves, int offset) {
        int count = 0, maxLength = 0; 
    
        for (int i = 0; i < stays.length; i++) {
            if (i + offset >= moves.length) break;
            if (moves[i+offset] == stays[i]) {
                count++;
                maxLength = Math.max(count, maxLength);
            } else {
                count = 0; 
            }
        }
        return maxLength; 
    }   
    
}
