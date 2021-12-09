package code_forces.java;

import java.util.Scanner;

public class DominoPiling {

    public int solution(int m, int n){
        return (m*n) / 2;
    }



    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        DominoPiling dominoPiling = new DominoPiling();
        int maxDominos = dominoPiling.solution(m, n);
        System.out.println(maxDominos);


    }
    
}
