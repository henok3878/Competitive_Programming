package leet_code.java;

public class FlattenAMultilevelDoublyLinkedLis {
    public Node flatten(Node head) {
        flattenHelper(head);
        return head;
        
    }
    
    private Node flattenHelper(Node node){
        Node temp = node;
        Node l = new Node();
        while(temp != null){
            if(temp.child != null){
                Node last = flattenHelper(temp.child);
                temp.child.prev = temp;
                if(temp.next != null){
                    temp.next.prev = last;
                }
                last.next = temp.next;
                temp.next = temp.child;
                temp.child = null;
            }
            l = temp;
            temp = temp.next;
        }
        return l;
        
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};