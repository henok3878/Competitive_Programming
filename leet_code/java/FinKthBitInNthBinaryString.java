package leet_code.java;

public class FinKthBitInNthBinaryString {

    public char findKthBit(int n , int k){   
        if(n == 1)return '0';
        else{
            int pow = (int)Math.pow(2,n); int size = pow - 1; int prevSize = pow/2;
            if(k < prevSize){
                return findKthBit(n-1,k);
            }else{
                if(k == prevSize) return '1';
                else{
                    k = size + 1 - k;
                    char prev = findKthBit(n-1,k);
                    if(prev == '0') return '1';
                    return '0';
                }            
            }
        }      
    }  


    public static void main(String[] args){
        
    }
    
}
