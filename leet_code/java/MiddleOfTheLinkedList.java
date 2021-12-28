package leet_code.java;

import java.util.Stack;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int count = 0;
        int size = stack.size();
        while(count < size/2){
            stack.pop(); 
            count++;
        }
        if(size%2 == 0){
            return stack.pop().next;
        }
        return stack.pop();
        
    }
    
}
