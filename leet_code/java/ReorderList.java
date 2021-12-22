package leet_code.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderList {
    
    public void reorderList(ListNode head) {
        
        Queue<ListNode> tempQueue = new LinkedList();
        ListNode temp = head;
        while(temp != null){
            tempQueue.add(temp);
            temp = temp.next;
        }
        int length = tempQueue.size();        
        Queue<ListNode> firstHalf = new LinkedList();
        Stack<ListNode> secondHalf = new Stack();
        int count = 0;
        int midIndex = (length - 1)/2;
        while(!tempQueue.isEmpty()){
            if(count < midIndex){
                firstHalf.add(tempQueue.poll());
            }else {
                secondHalf.push(tempQueue.poll());
            }
            count++;
        }

        System.out.println("FirstHalf: " + firstHalf);
        System.out.println("SecondHalf: " + secondHalf);
        
        while(!firstHalf.isEmpty()){
            ListNode firstNode = firstHalf.poll();
            ListNode lastNode = secondHalf.pop();
            ListNode firstNodeNext = firstNode.next;
            ListNode lastNodeNext = lastNode.next;
            if(!secondHalf.isEmpty()){
                ListNode secondLast = secondHalf.peek();
                secondLast.next = lastNodeNext; 
            }

            lastNode.next = firstNodeNext;
            firstNode.next = lastNode;
        
        }
    }


    public static void main(String[] args){
        /*  

        EX1:    Input: head = [1,2,3,4]
            Output: [1,4,2,3]
        EX2:    Input: head = [1,2,3,4,5]
            Output: [1,5,2,4,3]
        */
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(root);
        int idx = 0;
        while(root != null && idx < 10){
            System.out.print(root.val +" -> ");
            root = root.next;
            idx++;
        }


    }
    
    
    
    
    
    

    
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(){
        return ""+val;
    }
}
