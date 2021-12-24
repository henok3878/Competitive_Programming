package leet_code.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {



    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        
        public void insert(String word){
            TrieNode temp = root;
            for(int i = 0; i < word.length() ; i++){
                char c = word.charAt(i);
                if(temp.children[c - 'a'] == null){
                    temp.children[c-'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
                
            }
            temp.isEnd = true;
        }
        
        public TrieNode isWord(String word){
            TrieNode node = getNode(word);
             if(node != null && node.isEnd == true){
                 return node;
             }
            return null;
        }
        
        public boolean isPrefix(String prefix){
            TrieNode node = getNode(prefix);
            return node != null;
            
        }
        
        public TrieNode getNode(String prefix){
            TrieNode temp = root;
            for(int i = 0; i < prefix.length() ; i++){
                char c = prefix.charAt(i);
                if(temp.children[c - 'a'] == null){
                    return null;
                }
                temp = temp.children[c - 'a'];
                
            }
          return temp;
            
        }
        
        
        
    }
    
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        HashSet<String> ans = new HashSet();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int m  = 0; m < board.length ; m++){
            for(int n = 0; n < board[0].length; n++){
                StringBuilder wordBuilder = new StringBuilder();
                dfs(m,n,board,trie,wordBuilder, ans,visited);
            }
        }
        return new ArrayList<>(ans);
        
    }
    
    public boolean dfs(int row, int col,char[][] board, Trie trie,StringBuilder wordBuilder,HashSet<String> ans,boolean[][] visited){
        if(visited[row][col]){
            return false;
        }
        wordBuilder.append(board[row][col]);
        visited[row][col]= true;
        String word = wordBuilder.toString();
        TrieNode node = trie.isWord(word);
        if(node != null){
            node.isEnd = false;
            ans.add(word);
        }
        if(trie.isPrefix(word)){
            if(col < board[0].length - 1){                      
                dfs(row,col + 1, board,trie,wordBuilder,ans,visited);
            }   
             if(col > 0){
               dfs(row,col - 1, board,trie,wordBuilder,ans,visited);
            }   
             if(row < board.length - 1 ){
                  dfs(row + 1,col, board,trie,wordBuilder,ans,visited);
            }   
             if(row > 0){
                dfs(row - 1,col, board,trie,wordBuilder,ans,visited);
               
            }   
            
            
        }
        wordBuilder.deleteCharAt(wordBuilder.length() - 1);
        visited[row][col] = false;
        return false;
    }








    public static void main(String[] args){
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println("Result: " + result);
    }
    

    
}


