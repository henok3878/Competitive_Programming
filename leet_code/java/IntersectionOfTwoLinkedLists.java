package leet_code.java;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null || tempB != null){
            if(tempA == tempB) break;
            if(tempA == null) tempA = headB;
            else tempA = tempA.next;
            if(tempB == null) tempB = headA;
            else tempB = tempB.next;
        }
        return tempA;
    }
    
}
