package leet_code.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len==k) return "0";
        int lengAfterRem = len-k;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i<len; i++) {
            int cur = num.charAt(i)-'0';
            /*
                Pop from the stack while the stack is not empty and stack.peek() > currentNum and 
                characters left unprocessed in num > characers left from the length of the num after removing k digits
            */
            while (!stk.isEmpty() && stk.peek()>cur && lengAfterRem-stk.size()<=(len-i-1)) {
                stk.pop();
            }
            if (stk.size()<lengAfterRem) {
                stk.push(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> li = new ArrayList<>(stk);
        for (int nxt : li) {
            if (nxt==0 && sb.length()==0) continue;
            sb.append(nxt);
        }
        String ans = sb.toString();
        return ans.equals("") ? "0" : ans;
    }
    
}
