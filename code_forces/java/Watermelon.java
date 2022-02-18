package code_forces.java;

import java.util.Scanner;

public class Watermelon {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        boolean isPossible = false;
        for(int i = 0; i < w; i+=2){
            for(int j = 0; j < w; j +=2){
                if(i + j == w){
                    isPossible = true;
                    break;
                }
            }
        }
        if(isPossible){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
    
}
