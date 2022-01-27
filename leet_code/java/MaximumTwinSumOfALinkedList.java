package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumOfALinkedList {

    public int pairSum(ListNode head) {
        List<ListNode> nodes = new ArrayList();
        while(head != null){
            nodes.add(head);
            head = head.next;
        }
        int max = 0;
        for(int i = 0; i < nodes.size(); i++){
            max = Math.max(max,nodes.get(i).val + nodes.get(nodes.size() - 1- i).val);
        }
        return max;
    }
    
}
