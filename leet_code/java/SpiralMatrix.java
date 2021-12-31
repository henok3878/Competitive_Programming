package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        sprialOrderHelper(matrix,0,matrix.length,matrix[0].length,ans);
        return ans;
    }
    
    private void sprialOrderHelper(int[][] matrix, int st, int row, int col,
                                   List<Integer> ans){
        if(row < 1 || col < 1){
            return;
        }
        if(row == 1){
            for(int c = st; c < st + col; c++){
                ans.add(matrix[st][c]);
            }
        }
        else if(row == 2){
            for(int c = st; c < st + col; c++){
                ans.add(matrix[st][c]);
            }
            for(int c = st + col - 1; c >= st; c--){
                ans.add(matrix[st+1][c]);
            }
           
        }else if(col == 1){
             for(int r = st; r < st + row; r++){
                ans.add(matrix[r][st]);
            }
        }
        
        else{
             for(int c = st; c < st + col;c++){
                 ans.add(matrix[st][c]);
             }
            for(int r = st + 1; r < st + row; r++){
                ans.add(matrix[r][st+col-1]);
            }
            for(int c = st + col - 2; c >= st; c--){
                ans.add(matrix[st+row-1][c]);
            }
            for(int r = st + row - 2; r > st; r--){
                ans.add(matrix[r][st]);
            }
            sprialOrderHelper(matrix,st+1,row-2,col-2,ans);
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> ans = spiralMatrix.spiralOrder(matrix);
        System.out.println("Output: " + ans);
        //matrix = [[1,2,3],[4,5,6],[7,8,9]]
    }
}
