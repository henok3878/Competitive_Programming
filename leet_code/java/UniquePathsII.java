package leet_code.java;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        else if(obstacleGrid[row-1][col-1] == 1) return 0;
        
        obstacleGrid[0][0] = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if((i + j) == 0) continue;
                
                if(obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else if(i == 0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                } 
                else if(j == 0) obstacleGrid[i][j] = obstacleGrid[i-1][j];
                else {
                    int left = (i-1 >= 0) ? obstacleGrid[i-1][j] : 0;
                    int up = (j - 1 >= 0)? obstacleGrid[i][j-1] : 0;
                    obstacleGrid[i][j] = left + up;  
                }
               
            }
        }
        return obstacleGrid[row-1][col-1];
        
    }
}
