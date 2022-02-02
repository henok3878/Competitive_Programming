package leet_code.java;

public class ValidateBinarySearchTree {
    
    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidHelper(TreeNode root, long min, long max){
        if(root == null) return true;
        
        if(root.val >= max || root.val <= min) return false;
        
        return isValidHelper(root.left,min,root.val) && isValidHelper(root.right,root.val,max);
    }
}
