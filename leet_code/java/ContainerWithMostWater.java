package leet_code.java;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while(r >= l){
            area = Math.max(area,Math.min(height[l],height[r]) * (r - l));
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
       return area; 
    }
    
}
