package leet_code.java;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }else{
            TreeNode node;
            if(root.val > val){
                node = insertIntoBST(root.left,val);
                root.left = node;
            }
            else{
                node = insertIntoBST(root.right,val);
                root.right = node;
            }
            return root;
        }
    }
    
}
