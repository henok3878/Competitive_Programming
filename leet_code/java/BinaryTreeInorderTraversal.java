package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList();
        inorderHelper(root,ans);
        return ans;   
    }
    
    private void inorderHelper(TreeNode root, List<Integer> ans){
        
        if(root == null) return;
        inorderHelper(root.left,ans);
        ans.add(root.val);
        inorderHelper(root.right,ans);
        
    }
}
