package leet_code.java;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        count(countS,s);
        count(countT,t);
        return (char)(findDif(countS,countT) + 'a');
        
    }
    
    private void count(int[] nums, String s){
        for(int i = 0; i < s.length(); i++) nums[s.charAt(i) - 'a']++;
    }
    
    private int findDif(int[] s, int[] t){
        for(int i = 0; i < 26; i++)    if(s[i] != t[i]) return i;
        return -1;
    }
}
