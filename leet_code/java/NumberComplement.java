package leet_code.java;

public class NumberComplement {
    public int findComplement(int num) {
        String binary = decimalToBinary(num);
        String reversed = reverseBits(binary);
        return binaryToDecimal(reversed);
        
    }
    
    public String decimalToBinary(int num){
        StringBuilder sb = new StringBuilder();
        int reminder;        
        if(num == 0){
            return "0";
        }
        while(num > 0){
            reminder = num%2;
            num = num/2;
            sb.append(reminder);    
        }
        return sb.reverse().toString();
    }
    
    public int binaryToDecimal(String num){
        // 1010 -> 10
        int ans = 0;
        for(int i = num.length()- 1; i >= 0; i--){
            if(num.charAt(i) == '1'){
                ans += Math.pow(2,num.length()-1 - i); 
            }
        }
        return ans;
    }
    
    public String reverseBits(String binary){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '0'){
                sb.append("1");
            }else{
                sb.append("0");   
            }
        }
        return sb.toString();
    }
    
}
