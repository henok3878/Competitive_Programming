package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {


    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> nums = new ArrayList();
        findPath(root,sb,nums);
        int sum = 0;
        for(String num : nums){
            sum += Integer.parseInt(num);
        }
        return sum;
        
    }
    private void findPath(TreeNode node, StringBuilder builder, List<String> nums){
        if(node.left ==  null && node.right == null){
            builder.append(node.val);
            nums.add(builder.toString());
            return;
        }
        builder.append(node.val);
        if(node.left != null){
             findPath(node.left, builder,nums);
             builder.deleteCharAt(builder.length() - 1);
        }
        if(node.right != null){
            findPath(node.right,builder,nums);
             builder.deleteCharAt(builder.length() - 1);
        }
        
    }
    
}
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
}