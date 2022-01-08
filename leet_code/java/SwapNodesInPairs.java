package leet_code.java;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0,head);
        swapPairsHelper(temp);
        return temp.next;
    }
    
    private void swapPairsHelper(ListNode current){
        if(current.next == null || current.next.next == null){
            return;
        }
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        second.next = first;
        current.next = second;
        
        swapPairsHelper(current.next.next);
    }

    public static void main(String[] args){

    }
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
