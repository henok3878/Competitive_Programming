package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap();
        
        Node temp = head;
        Node newHead = new Node(-1);
        Node dummy = newHead;
        
        while(temp != null){
            dummy.next = new Node(temp.val);
            dummy = dummy.next;
            oldToNew.put(temp,dummy);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            oldToNew.get(temp).random = oldToNew.get(temp.random);
            temp = temp.next;
        }
        
        return newHead.next;
        
    }
    
}
