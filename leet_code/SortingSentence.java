package leet_code;

import java.util.Arrays;
import java.util.Comparator;

public class SortingSentence {

    public String sortSentence(String s) {
        
        String[] words = s.split(" ");
        Arrays.sort(words,new Comparator<String>() {
            public int compare(String o1, String o2) {
                char o1LastDig = o1.charAt(o1.length()-1);
                char o2LastDig = o2.charAt(o2.length()-1);
                if(o1LastDig > o2LastDig){
                    return 1;
                }
                else if(o1LastDig == o2LastDig){
                    return 0;
                }
                return -1;
            }
        });
        return createStringFromArrayOfString(words);
    }
    public  String createStringFromArrayOfString(String[] arrOfStrings){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arrOfStrings.length; i++) {
            String suffix = " ";
            if(i==arrOfStrings.length - 1){
                suffix = "";
            }
            String currntWord = arrOfStrings[i];
            sb.append(currntWord.substring(0,currntWord.length()-1)+suffix);
        }
        String str = sb.toString();
        return str;
    }

    public static void main(String[] args){
        String s = "is2 sentence4 This1 a3";
        SortingSentence sortingSentence = new SortingSentence();
        String sortedSentence = sortingSentence.sortSentence(s);
        System.out.println("Result : " + sortedSentence);
    }
    
}
