package leet_code.java;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null){return head;}
        
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenSt = even;
        ListNode oddLst = odd;
        
        while(even != null && odd != null){
                oddLst = odd;
                odd.next = even.next;
                odd = odd.next;
                even.next = (odd != null ) ? odd.next : null;
                even = even.next;         
        }
        oddLst = (odd == null) ? oddLst : odd;
        oddLst.next = evenSt;
        return head;
        
    }
    
}
