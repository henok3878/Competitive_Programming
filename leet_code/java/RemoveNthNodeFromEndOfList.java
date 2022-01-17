package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
   
    int size = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEndHelper(head,0,n);
    }
    
    private ListNode removeNthFromEndHelper(ListNode head, int count, int n){
       
        if(head == null)return head;
        size++;
        head.next = removeNthFromEndHelper(head.next,count + 1, n);
        if(count == (size - n))   return head.next;
        return head;
    }
    
}
