package leet_code.java;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean isFound = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    isFound = searchWord(board,i,j,word,visited,1);
                }
                if(isFound){
                    return true;
                }
                visited[i][j] = false;
                System.out.println("Next");
            }
        }
        return isFound;
        
        
    }
    
    private boolean searchWord(char[][] board,int i, int j, String word, boolean[][] 
                              visited, int currCharPos){
        if(word.length() == currCharPos){
            return true;
        }
        else{
            if(j+1 < board[0].length && !visited[i][j+1] && board[i][j+1] == word.charAt(currCharPos)){
                visited[i][j+1] = true;
                boolean res = searchWord(board,i,j+1,word,visited,currCharPos + 1);
                if(res){
                    return true;
                }
                visited[i][j+1] = false;
            }
             if(j-1 >= 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(currCharPos)){
                visited[i][j-1] = true;
                boolean res = searchWord(board,i,j-1,word,visited,currCharPos + 1);
                if(res){
                    return true;
                }
                visited[i][j-1] = false;
            }
             if(i + 1 < board.length &&  !visited[i+1][j] && board[i+1][j] == word.charAt(currCharPos)){
                visited[i+1][j] = true;
                boolean res = searchWord(board,i+1,j,word,visited,currCharPos + 1);
                if(res){
                    return true;
                }
                visited[i+1][j] = false;
            }
             if(i- 1 >= 0 && !visited[i-1][j] && board[i-1][j] == word.charAt(currCharPos)){
               
                visited[i-1][j] = true;
                boolean res = searchWord(board,i-1,j,word,visited,currCharPos + 1);
                if(res){
                    return true;
                }
                visited[i-1][j] = false;
            }    
        }
        return false;
        
    }
}
