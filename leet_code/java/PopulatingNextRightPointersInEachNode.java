//link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

package leet_code.java;

public class PopulatingNextRightPointersInEachNode {
    
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        if(root.left != null){
            if(root.next != null)
                root.right.next = root.next.left;
            root.left.next = root.right;
            connect(root.left);
            connect(root.right);
        }
        return root;
        
    }

    public static void main(String[] args){
       
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
