package leet_code.java;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {


        
    }

    public void solveSudokuHelper(char[][] board, int row, int col){



    }

    boolean isValidMove(char[][] board, int row, int col, int num){
        boolean isValid = true;
        // check row
       for(int i = 0; i < 9; i++){
           if(board[row][col] == board[i][col]){
               isValid = false;
           }
       }
       // check col 
       for(int i = 0; i < 9; i ++){
           if(board[row][col] == board[col][i]){
               isValid = false;
           }
       }

       // check submatrix 
       int stRow = row - row%3;
       int stCol = col - col%3;
       for(int i =0; i < 3; i++){
           for(int j = 0; j < 3; j++){
              if(  board[i+stRow][j+stCol] == num){
                  isValid = false;
              }

           }
       }

       
       return isValid;
    }
    
}
