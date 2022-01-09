package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        
        if(n == 1){
            ans.add(new TreeNode());
            return ans;
        }
        else if(n%2 == 0){
            return ans;    
        }
        else{
            for(int i = 1; i < n-1 ; i++){
                int left = i;
                int right = (n-1) - left;
                List<TreeNode> leftNodes = allPossibleFBT(left);
                List<TreeNode> rightNodes = allPossibleFBT(right);
                for(TreeNode l : leftNodes){
                    for(TreeNode r : rightNodes){
                        ans.add(new TreeNode(0,l,r));
                    }
                }
            }   
        }
        return ans;
    }
    
}
