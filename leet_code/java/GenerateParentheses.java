package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n,n,"",ans);
      return ans;
}

private void generateParenthesis(int numOfOpen, int numOfClose, String res, List<String> ans){
  if(numOfOpen == 0 && numOfClose == 0){
      ans.add(res);
  }
  else{
      if(numOfOpen == 0){
          generateParenthesis(numOfOpen,numOfClose - 1, res + ")",ans);
      }
      else if(numOfClose > numOfOpen){
          generateParenthesis(numOfOpen - 1,numOfClose,res + "(",ans);       
          generateParenthesis(numOfOpen, numOfClose - 1, res + ")", ans);
      }else{
          generateParenthesis(numOfOpen - 1,numOfClose,res + "(",ans);    
      }
      
  }
}
}
