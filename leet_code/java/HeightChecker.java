package leet_code.java;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] occuranceCounter = new int[101];
        for(int i =0 ; i < heights.length; i++){
            occuranceCounter[heights[i]] = occuranceCounter[heights[i]] + 1;
        }
        for(int i = 1; i < occuranceCounter.length; i++){
            occuranceCounter[i] = occuranceCounter[i] + occuranceCounter[i-1];
        }
        int misMatchedIndecies = 0;
        for(int i = 0; i < heights.length; i++){
            int currHeight = heights[i];
            int stIndexInSorted = occuranceCounter[currHeight - 1];
            int endIndexInSorted = occuranceCounter[currHeight] - 1;
            if(i > endIndexInSorted || i < stIndexInSorted){
                misMatchedIndecies++;
            }
        }

        return misMatchedIndecies;
        
    }


    public static void main(String[] args){
        int[] heights = {1,1,4,2,1,3};
        HeightChecker heightChecker = new HeightChecker();
        int mismatches = heightChecker.heightChecker(heights);
        System.out.println("result : " + mismatches);
    }

    
}
