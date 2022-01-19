package hacker_rank.java;

public class CycleDetection {
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    
}
class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}
