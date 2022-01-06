package code_forces.java;
import java.util.Scanner;

public class CodeFor1 {

    public static  long find(long n, long l, long r,long currSt, long currEnd){
            //System.out.println("n: " + n + " l: " + l + " r: " + r + " cst: " + currSt + " ced: " + currEnd);
            if(currSt > r || currEnd < l || n < 1){
                //System.out.println("Ret 0");
                return 0;
            }
            if(n == 1){
                //System.out.println("Ret 1");
                return 1;
            }
            long mid = (currEnd + currSt) / 2; 
            long left = find(n/2,l,r,currSt, mid-1);
            long right = find(n/2,l,r,mid+1,currEnd);
            long middle = find(n%2,l,r,mid,mid);
            return left+right+middle;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  
        long[] input = new long[3];
        for(int i = 0; i< input.length; i++){
            input[i] = Long.parseLong(sc.next());
        }

        long length = 1;
        long n = input[0];
        long l = input[1];
        long r = input[2];
        long temp = n;
        while(temp > 1){
            length = 2*length + 1;
            temp= temp/2;
        }
        long ans = find(n,l,r,1,length);
        System.out.println(ans);
    }
    
}
