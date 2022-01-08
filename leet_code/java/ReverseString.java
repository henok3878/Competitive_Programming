package leet_code.java;

public class ReverseString {
    public void reverseString(char[] s) {
        reverseStringHelper(s,0);
    }
    
    private void reverseStringHelper(char[] s, int stIdx){
        if(stIdx >= s.length){
            return;
        }
        char last = s[s.length-1];
        for(int i = s.length - 1; i > stIdx; i--){
            s[i] = s[i-1];
        }
        s[stIdx] = last;
        reverseStringHelper(s,stIdx + 1);
        
    }

    public static void main(String[] args){
        
    }
}
