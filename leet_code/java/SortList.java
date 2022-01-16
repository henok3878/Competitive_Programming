package leet_code.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        Queue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        ListNode temp = head;
        while(temp != null){
            pq.add(temp);
            temp = temp.next;
        }
        
        ListNode dummyPtr = newHead;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            dummyPtr.next = min;
            dummyPtr = min;
            min.next = null;
            
        }
        
        return newHead.next;
        
    }
    
}
