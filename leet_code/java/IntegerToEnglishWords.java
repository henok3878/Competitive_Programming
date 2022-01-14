package leet_code.java;

import java.util.HashMap;

public class IntegerToEnglishWords {
    
    String[] common = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",                                               "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",                                                 "Eighteen", "Nineteen"};
        
    String[] tenDigits =   {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] others = {"Hundred", "Thousand", "Million", "Billion"};
    HashMap<Integer,String> map = new HashMap();
        
        
        
    public String numberToWords(int num) {
        
        if(num == 0){
            return "Zero";
        }
        map.put(100,"One Hundred");
        map.put(1000,"One Thousand");
        map.put(1000000,"One Million");
        map.put(1000000000,"One Billion");
        
        
        return numberToWordsHelper(num);        
    }
    
    private String numberToWordsHelper(int num){
        if(map.containsKey(num)){
            return map.get(num);
        }
        if(num < 20){
            return common[num];
        }
        else if(num < 100){
            String res = num%10 == 0 ? ""  : (" " + numberToWordsHelper(num%10));
            return tenDigits[num/10] + res;
        }
        else if(num < 1000){
            String res = num%100 == 0 ? "" :  (" " + numberToWordsHelper(num%100));
            return numberToWordsHelper(num/100) + " " + others[0] + res;
        }
        else if(num < 1000000){
             String res = num%1000 == 0 ? "" :  (" " + numberToWordsHelper(num%1000));
             return numberToWordsHelper(num/1000) + " " + others[1] + res;
        }
        else if(num < 1000000000){
             String res = num%1000000 == 0 ? "" :  (" " + numberToWordsHelper(num%1000000));
             return numberToWordsHelper(num/1000000) + " " + others[2] + res;
        }
        String res = num%1000000000 == 0 ? "" :  (" " + numberToWordsHelper(num%1000000000));
        return numberToWordsHelper(num/1000000000) + " " + others[3] + res;
    }
}
