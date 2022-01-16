package leet_code.java;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null){
           tempB = headB;
           while(tempB != null){
               if(tempB ==  tempA){
                   return tempA;
               }
               tempB = tempB.next;
           }
           tempA = tempA.next;
        }
        return null;
        
    }
    
}
