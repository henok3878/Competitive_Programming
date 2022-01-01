package leet_code.java;

public class Pow_x_n{
    

    public double myPow(double x, int n) {
        if(n < 0){
            return 1/pow(x,n*-1);
        }
        return pow(x,n);
        
    }
    
    public double pow(double x , int n){
       
        if(n==0)
            return 1;    
        double temp = pow(x,n/2);
        if(n % 2 == 0)
            return temp * temp ;
        else
            return x * temp * temp ;
    }

    public static void main(String[] args){



    }
}
