package leet_code.java;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] possibleSquareAtCell = new int[n][m];
        int maxSquareLength = 0;
        int tempSqLength;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                tempSqLength = 0;
                if(!(matrix[i][j] == '0')){
                        tempSqLength = 1;
                }
                if(i == 0 || j == 0 || tempSqLength == 0){
                    possibleSquareAtCell[i][j] = tempSqLength;
                }
                else{
                    tempSqLength = Math.min(Math.min(possibleSquareAtCell[i-1][j],possibleSquareAtCell[i][j-1]), possibleSquareAtCell[i-1][j-1]) + 1;
                    possibleSquareAtCell[i][j] =  tempSqLength;
                }
                 if(maxSquareLength < tempSqLength){
                        maxSquareLength = tempSqLength;
                }
            }
        }   

        return maxSquareLength*maxSquareLength;   
    }

    public static void main(String[] args){
        MaximalSquare maximalSquare = new MaximalSquare();
        // write tests here


    }
    
}
