package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        List<ListNode> linkedList = new ArrayList();
        while(head != null){
            linkedList.add(head);
            head = head.next;
        }
        if(linkedList.size() < 2){
            return null;
        }
        int remIdx = linkedList.size() - n;
        if(remIdx - 1 < 0){
          return  linkedList.get(1);
        }
        ListNode prev = linkedList.get(remIdx - 1);
        ListNode remNode = linkedList.get(remIdx);
        prev.next = remNode.next;
        remNode.next = null;
        
        return linkedList.get(0);
    }
    
}
