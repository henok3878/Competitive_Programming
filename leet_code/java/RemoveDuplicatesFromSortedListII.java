package leet_code.java;

public class RemoveDuplicatesFromSortedListII {


    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                while(head != null && head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                temp.next = head.next;
            }else{
               temp = temp.next;
            }
            head = head.next;
        }
        return dummy.next;
        
    }
    
}
