package leet_code.java;
class WordDictionary {
    
    Node root;

    public WordDictionary() {
        root = new Node();   
    }
    
    public void addWord(String word) {
        Node temp = root;
        for(int i = 0; i < word.length(); i++){
            int curr = word.charAt(i) - 'a';
            if(temp.children[curr] == null) temp.children[curr] = new Node();
            temp = temp.children[curr];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        return searchHelper(temp,word,0);
    }
    
    private boolean searchHelper(Node temp, String word, int idx){
        for(int i = idx; i < word.length(); i++){
      
            int curr = word.charAt(i) - 'a';
            if(word.charAt(i) == '.'){
                for(Node node : temp.children){
                    if(node != null && searchHelper(node,word,i+1)) return true;
                }
                return false;
            }
            else if(temp.children[curr] == null) return false;
            else temp = temp.children[curr];
        }
        return temp != null && temp.isEnd;  
    }
 
}

class Node {
    Node[] children;
    boolean isEnd;
    public Node(){
        children = new Node[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */