package leet_code.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder numBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ']') {
                stack.push("]");
            } else if (c == '[') {
                StringBuilder local = new StringBuilder();
                String popString = stack.pop();
                while (popString.charAt(0) != ']') {
                    local.append(popString);
                    popString = stack.pop();
                }
                stack.push(local.toString());
            } else if (Character.isDigit(c)) {
                numBuilder.insert(0, c);
                if (i == 0 || !Character.isDigit(s.charAt(i - 1))) {
                    String localString = stack.pop();
                    StringBuilder genString = new StringBuilder();
                    int times = Integer.parseInt(numBuilder.toString());
                    for (int j = 0; j < times; j++) {
                        genString.append(localString);
                    }
                    stack.push(genString.toString());
                    numBuilder = new StringBuilder();
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        String element = stack.poll();
        while (element != null) {
            resultBuilder.append(element);
            element = stack.poll();
        }
        return resultBuilder.toString();
    }
}



