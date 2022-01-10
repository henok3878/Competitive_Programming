package leet_code.java;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1,head);
        removeElementsHelper(dummy,val);
        return dummy.next;
        
    }
    
    private void removeElementsHelper(ListNode node, int val){
        if(node.next == null){
            return;
        }
        ListNode curr = node;
        ListNode next = node.next;
        if(next.val == val){
            curr.next = next.next;
            next.next = null;
            removeElementsHelper(curr,val);
        }else{
            removeElementsHelper(next,val);   
        }
       
    }
    
}
