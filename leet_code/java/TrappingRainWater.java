package leet_code.java;

public class TrappingRainWater {
    public int trap(int[] height) {
        
        int[] rightMax = new int[height.length];
        int currMax = 0;
        for(int i = height.length - 1; i >= 0; i--){
            if(currMax < height[i]){
                currMax = height[i];
            }
            rightMax[i] = currMax;
        }
        int leftMax = 0;
        int trappedWater = 0;
        for(int i = 0; i < height.length ;i++){
            if(leftMax < height[i]){
                leftMax = height[i];
            }
            trappedWater += Math.min(rightMax[i], leftMax) - height[i];
            
        }
        return trappedWater;
    }
    
}
