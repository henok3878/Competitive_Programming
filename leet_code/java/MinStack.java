package leet_code.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStack {

    List<Integer> trackMin;
    List<Integer> stack;

    public MinStack() {
        stack = new ArrayList<>();
        trackMin = new ArrayList<>();
        
    }
    
    public void push(int val) {
        stack.add(val);
        trackMin.add(val);
        Collections.sort(trackMin);
    }
    
    public void pop() {
        int lastElem = stack.get(stack.size() - 1);
        for(int i = 0; i < trackMin.size(); i++){
            if(lastElem == trackMin.get(i)){
                trackMin.remove(i);
            }
        }
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return trackMin.get(0);
    }
    
}
