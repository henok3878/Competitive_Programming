package leet_code.java;

import java.util.Stack;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        return fastPtr.next == null ? slowPtr : slowPtr.next;
    }
}
