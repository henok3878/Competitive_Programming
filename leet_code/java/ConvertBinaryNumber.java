package leet_code.java;

public class ConvertBinaryNumber {

    public int getDecimalValue(ListNode head) {
        if(head == null){
            return 0;
        }
        else if(head.val == 1){
            return getDecimalValueHelper(head) + getDecimalValue(head.next);
        }
       return getDecimalValue(head.next);
    
    
    }
    private int getDecimalValueHelper(ListNode head){
    if(head.next == null){
        return 1;
    }
    return  2 * getDecimalValueHelper(head.next);   
}


    public static void main(String[] args){

        ConvertBinaryNumber convertBinaryNumber = new ConvertBinaryNumber();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        int decimalValue = convertBinaryNumber.getDecimalValue(head);
        System.out.println("Decimal value: " + decimalValue);

    }

    
}


 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


