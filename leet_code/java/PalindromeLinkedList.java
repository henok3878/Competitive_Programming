package leet_code.java;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null ){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        // reverse the half 
        slowPtr = reverse(slowPtr);
        
        boolean isPalindrome = true;     
        // compares each element between the reversed and the orginal list 
        while(slowPtr != null){
            if(head.val != slowPtr.val){
                isPalindrome = false;
                break;
            }
            head = head.next;
            slowPtr = slowPtr.next;
        }
        return isPalindrome;
        
    }
    
    private ListNode reverse(ListNode node){
        if(node.next == null){
            return node;
        }
        else{
            ListNode temp = reverse(node.next);
            node.next.next = node;
            node.next = null;
            return temp;
        }
    }
    
}
