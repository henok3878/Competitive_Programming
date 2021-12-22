package leet_code.java;

public class  ImplementTrie {

    


    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("word");
        System.out.println("search word: " + trie.search("word"));

    }
    
}

class Trie {
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode('/');
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if(temp.children[c - 'a'] == null){
                temp.children[c - 'a'] = new TrieNode(c);
            }
            temp = temp.children[c- 'a'];
        }
        temp.isEnd = true;
        
    }
    
    public boolean search(String word) {
        TrieNode n = getNode(word);
        return n != null && n.isEnd == true;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode n = getNode(prefix);
        return n != null;
        
    }
    
    private TrieNode getNode(String word){
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(temp.children[c - 'a'] == null) return null;
            temp = temp.children[c-'a'];
        }
        return temp;
    }
    
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        char current;
        
        TrieNode(char c){
            current = c;
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}