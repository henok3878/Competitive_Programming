package leet_code.java;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    

    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Map<Node, Node> oldToNew = new HashMap();
        Node temp = head;
        
        oldToNew.put(head, new Node(head.val));
        
        while(temp != null){
            
            if(!oldToNew.containsKey(temp)){
                oldToNew.put(temp ,new Node(temp.val));        
            }
            if(temp.next != null){
                 if(!oldToNew.containsKey(temp.next)){
                    oldToNew.put(temp.next, new Node(temp.next.val));
                 }
                 oldToNew.get(temp).next = oldToNew.get(temp.next); 

            }
            if(temp.random != null){
                if(!oldToNew.containsKey(temp.random)){
                    oldToNew.put(temp.random, new Node(temp.random.val));
                }
                oldToNew.get(temp).random = oldToNew.get(temp.random); 
            }
            temp = temp.next;
        }
        
        return oldToNew.get(head);
        
    }
    
}

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
