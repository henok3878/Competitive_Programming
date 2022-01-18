package leet_code.java;

class MyLinkedList {
    
    Node head;
    int size;
    public MyLinkedList() {
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        int idx = 0;
        Node temp = head;
        while(temp != null){
            if(idx == index){
                return temp.val;
            }
            idx++;
            temp = temp.next;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
        }else{
            Node newNode = new Node(val);
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            size++;
        }
        
    }
    
                                
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
        }else if(index == size){
            addAtTail(val);
        }
        else if(index < size && index > 0){
            Node newNode = new Node(val);
            Node prev = head;
            Node curr = head;
            int idx = 0;
            while(curr != null){
                if(idx == index){
                    newNode.next = prev.next;
                    prev.next = newNode;
                }
                prev = curr;
                curr = curr.next;
                idx++;
            }
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index == 0){
            Node temp = head;
            head = head.next;
            temp.next = null;
            size--;
        }else if(index > 0 && index < size){
            Node prev = head;
            Node curr = head;
            int idx = 0;
            while(curr != null){
              
                if(idx == index){
                    prev.next = curr.next;
                    curr.next = null;
                }
                 prev = curr;
                curr = curr.next;
                idx++;
            }
            size--;
        }        
    }
    
    private void print(){
        Node temp = head;
        while(temp!= null){
            System.out.print( temp.val+" ,");
            temp = temp.next;
        }
        System.out.println();
    }
}
class Node{
    int val;
    Node next;
    
    public Node(int val){
        this.val = val;
    }
    
    public Node(int val, Node next){
        this.next = next;
    }
}
