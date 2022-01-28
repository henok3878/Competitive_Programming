package leet_code.java;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    DoublyListNode head, tail;
    int capacity; 
    Map<Integer,DoublyListNode> keyToNode;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;
        DoublyListNode node = keyToNode.get(key);
        moveToTail(node);
        return node.val;
    }
    
    private void moveToTail(DoublyListNode node){
        if (node.next == null) {
            return;
        }
        if(node.prev == null){
            head = head.next;
        } else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;   
    }
    
  
    
    public void put(int key, int value) {
        DoublyListNode newNode = new DoublyListNode(value,key);
        if(head == null){
           head = newNode;
           tail = newNode; 
        }else{
            if(keyToNode.containsKey(key)){
                DoublyListNode node = keyToNode.get(key);
                node.val = value;
                moveToTail(node);
                return;
            }
            
            if(keyToNode.size() == capacity){
                System.out.println("head.val :  " + head.key );
                keyToNode.remove(head.key);    
                head = head.next; 
                    
            }
            newNode.prev = tail;
            tail.next  = newNode;
            tail = newNode;
        }
        keyToNode.put(key,newNode);
    }
    
    private void print(){
        System.out.println("HashMap: " + keyToNode);
        DoublyListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){

        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2,2);
        lruCache.print();
        System.out.println(".get(1): " + lruCache.get(1));
        lruCache.put(3, 3);
        lruCache.print();
        System.out.println(".get(2): " + lruCache.get(2));
        lruCache.put(4,4);
        lruCache.print();
        System.out.println(".get(1): " + lruCache.get(1));
        System.out.println(".get(3): " + lruCache.get(3));
        System.out.println(".get(4): " +  lruCache.get(4));

    }



}

class DoublyListNode{
    int val;
    int key;
    DoublyListNode next;
    DoublyListNode prev;
    
    public DoublyListNode(int val, int key){
        this.val = val;
        this.key = key;
    }
    
    public DoublyListNode(int val,int key, DoublyListNode next, DoublyListNode prev){
        this.val = val;
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
    
    public String toString(){
        return this.val + "";
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */