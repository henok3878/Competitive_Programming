package leet_code.java;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode ans = new ListNode();
        helper(head, ans);
        return ans.next;
    }
    
    private ListNode helper(ListNode node, ListNode ans){
        if(node.next == null){
            ans.next = node;
            return node;
        }
        else{
            ListNode temp = helper(node.next,ans);
            temp.next = node;
            node.next = null;
            return node;
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