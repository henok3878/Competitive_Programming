package leet_code.java;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet();
        ListNode dummyHead = head;
        while(dummyHead != null){
            if(visited.contains(dummyHead)){
                return dummyHead;
            }
            visited.add(dummyHead);
            dummyHead = dummyHead.next;
        }
        return null;
    }
    
}
