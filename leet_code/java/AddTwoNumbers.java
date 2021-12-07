package leet_code.java;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = 0; int y = 0;
            if(l1 != null){
                x = l1.val;
            }
            if(l2 != null){
                y = l2.val;
            }
            int sum  = carry + x + y;
            carry = sum / 10;
            temp.val = sum%10;
            temp.next  = new ListNode();
            temp = temp.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        if(carry > 0){
            temp.val += carry;

        }
        return result; 
    }

    public static void main(String[] args){

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);



        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

       ListNode result =  new AddTwoNumbers().addTwoNumbers(l1, l2);
        while(result != null){
            System.out.print(result.val +"=>");
            result = result.next;
        }
    }
    
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
