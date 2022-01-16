package leet_code.java;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root != null)helper(root);
 }
 
 private TreeNode helper(TreeNode node){
     if(node.left == null && node.right == null){
         return node;
     }
     else{
         
         TreeNode left = (node.left != null ) ?  helper(node.left) : null;
         TreeNode right = (node.right != null) ? helper(node.right) : null;
         if(left != null){
             left.right = node.right;
         }
         node.right = (node.left != null ) ? node.left : node.right;
         node.left = null;
         return (right != null) ? right : left;
     }
 }
}
