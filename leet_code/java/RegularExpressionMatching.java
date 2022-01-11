package leet_code.java;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
           return s.length() == 0;
        }
        else if(p.length() > 1 && p.charAt(1) == '*'){
            
            if(isMatch(s,p.substring(2))){ // explore choosing empty string 
                return true;
            }
            else if (!s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))){
               return  isMatch(s.substring(1),p); // explore choosing the precding element a single time
            }
            
        }else if(!s.isEmpty() && (p.charAt(0) == '.' || (p.charAt(0) == s.charAt(0)))){
                return isMatch(s.substring(1),p.substring(1));
        }
        return false;
   }
    
}
