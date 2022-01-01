package leet_code.java;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1, head), curPrev = head, cur = head.next;
        while(cur != null) {
            ListNode jPrev = dummy, j = jPrev.next, curNext = cur.next;
            if(cur.val > curPrev.val) curPrev = cur;
            else {
                while(j.val < cur.val) {
                    jPrev = j; 
                    j = j.next;
                }
                cur.next = j;
                jPrev.next = cur;
                curPrev.next = curNext;
            }
            cur = curNext;
        }
        return dummy.next;
    }        

        //     currNext = curr.next;
        //     tempPrev = dummyHead;
        //     temp = dummyHead.next;
        //     ListNode tempCurr = new ListNode(curr.val);
        //     System.out.println("current: " + curr.val + " Temp: " + temp.val);

        //     while(temp != null && temp.val < curr.val){
        //         System.out.print("temp: " + temp.val+" , ");
        //         tempPrev = temp;
        //         temp = temp.next;
        //     }
        //     tempPrev.next = tempCurr;
        //     tempCurr.next = temp;
        //     currPrev.next = currNext;
            

        //     currPrev = new ListNode(curr.val, currNext);
        //     curr = currNext;
        //     count++;
        // }

        // return dummyHead.next;

    public static void main(String[] args){
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode head = new ListNode(4,new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode result = insertionSortList.insertionSortList(head);
        while(result != null){
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.println();
    }
    
}

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}