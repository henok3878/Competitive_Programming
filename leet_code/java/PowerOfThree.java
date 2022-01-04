package leet_code.java;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        else if(n == 1){
            return true;
        }
        else if(n%3 != 0){
                return false;
        }
        else{
            return isPowerOfThree(n/3);
        }
    }

    public static void main(String[] args){
        PowerOfThree powerOfThree = new PowerOfThree();
        int n = 27;
        System.out.println("is " + n +" power of three: " + powerOfThree.isPowerOfThree(27));
    }
    
}
