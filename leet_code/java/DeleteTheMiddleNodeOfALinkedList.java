package leet_code.java;

import java.util.Stack;

public class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {
        
        ListNode temp = head;
        Stack<ListNode> stack = new Stack();
        while(temp!= null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        if(size < 2){
            return null;
        }
        int mid = size/2;
        int count = 0;
        boolean isEven = size %2 == 0;
        ListNode prev = null;
        while((isEven && count < mid) || (!isEven && count <= mid)){
            prev = stack.pop();
            count++;
        }
        // if(size%2 == 0){
        //     prev = stack.pop();
        // }
        temp = stack.pop();
        temp.next = prev.next;
        return head;
        
    }
    
}
