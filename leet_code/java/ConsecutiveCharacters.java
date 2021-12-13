package leet_code.java;

public class ConsecutiveCharacters {

    public int maxPower(String s) {
        int stIndex = 0;
        int endIndex = stIndex + 1;
        int maxLength = 1;
        char prevChar = s.charAt(stIndex);
        int tempLength = 1;
        while(stIndex < s.length()){
            if(endIndex >= s.length()){
                if(maxLength < tempLength){
                    maxLength = tempLength;
                }
                break;
            }
            char currentChar = s.charAt(endIndex);
            
            if(prevChar == currentChar){
                    endIndex++;
                    tempLength++;         
            }
            else{
                prevChar = currentChar;
                stIndex = endIndex;
                endIndex = endIndex + 1;
                if(maxLength < tempLength){
                    maxLength = tempLength;
                }
                tempLength = 1;
            }

        }
        return maxLength; 
    }


    public static void main(String[] args){
        ConsecutiveCharacters consecutiveCharacters = new ConsecutiveCharacters();
        String s = "abbcccddddeeeeedcba";
        int maxPower = consecutiveCharacters.maxPower(s);
        System.out.println("result : " + maxPower);
    }
    
}
