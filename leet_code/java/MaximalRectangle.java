package leet_code.java;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] currRow = new int[matrix[0].length];
        
        int max = -1;
        
        Stack<Integer> stack = new Stack();
        int[][] minIndices = new int[currRow.length][2];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1') currRow[j] += matrix[i][j] - '0';
                else currRow[j] = 0;
            }
            max = Math.max(max,findMaxAreaInRow(currRow,stack,minIndices));
        }        
        return max;
    }   
    
    private int findMaxAreaInRow(int[] row, Stack<Integer> stack, int[][] minIndices){
        if(row.length == 1){
            return row[0];
        }
        stack.push(0);
        for(int i = 1; i < row.length ;i++){
            while(!stack.isEmpty() && row[stack.peek()] > row[i]){      
                minIndices[stack.pop()] = new int[]{0,i-1};
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            minIndices[stack.pop()][1] = row.length - 1;
        }
        stack.clear();
        
        stack.push(row.length-1);
        for(int i = row.length - 2; i >= 0 ;i--){
            while(!stack.isEmpty() && row[stack.peek()] > row[i]){         
                minIndices[stack.pop()][0] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            minIndices[stack.pop()][0] = -1;
        }
        stack.clear();
        
        int max = -1;
        for(int i = 0; i < minIndices.length;i++){
            max = Math.max(max,(minIndices[i][1] - minIndices[i][0]) * row[i]);
        }
        return max;
    }    

    public static void main(String[] args){
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        /*
        [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        */
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = maximalRectangle.maximalRectangle(matrix);
        System.out.println("ans: " + res);


    }



}
