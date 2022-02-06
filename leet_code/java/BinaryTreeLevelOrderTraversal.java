package leet_code.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList();
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(temp);
                
        }
            
        return ans;
    }
}
