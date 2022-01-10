package leet_code.java;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode reversedHead = new ListNode();
        ListNode dummy = reversedHead;
        //creates a copy of the orginal list 
        while(temp != null){
            dummy.next = new ListNode(temp.val);
            dummy = dummy.next;
            temp = temp.next;
        }
        
        boolean isPalindrome = true;
        
        // reverse the copied list 
        reversedHead = reverse(reversedHead.next);
        
        // compares each element between the reversed and the orginal list 
        while(reversedHead != null){
            if(head.val != reversedHead.val){
                isPalindrome = false;
                break;
            }
            head = head.next;
            reversedHead = reversedHead.next;
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
