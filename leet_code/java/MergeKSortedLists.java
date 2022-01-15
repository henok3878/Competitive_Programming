package leet_code.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        else if(lists.length == 1){
            return lists[0];
        }
        Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for(ListNode n : lists){
            if(n!=null) pq.add(n);
        }
        ListNode mergedHead = new ListNode();
        ListNode dummy = mergedHead;
        while(!pq.isEmpty()){
           ListNode min =  pq.poll();
           dummy.next = min;
           dummy = dummy.next;
           min = min.next; 
           if(min != null) pq.add(min); 
        }
        return mergedHead.next;   
    }
    
}
