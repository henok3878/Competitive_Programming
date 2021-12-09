package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for(int i = 1 ; i <= n ; i++){
            if(i%3 == 0 && i%5 == 0){
               answer.add("FizzBuzz");
            }
            else if(i%3 == 0){
               answer.add("Fizz");
            }
            else if(i%5 == 0){
                answer.add("Buzz");
            }
            else{
                answer.add(i + "");
            }
        }
        return answer;
        
    }

    public static void main(String[] arg){
        FizzBuzz fizzBuzz = new FizzBuzz();

        List<String> answers = fizzBuzz.fizzBuzz(15);
        for(String answer : answers){
            System.out.print(answer + ", ");
        }
    }
    
}
