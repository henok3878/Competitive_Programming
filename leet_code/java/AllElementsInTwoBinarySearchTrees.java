package leet_code.java;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans1 = new ArrayList();
        List<Integer> ans2 = new ArrayList();
        List<Integer> res = new ArrayList();
        if(root1 != null ) getElems(ans1,root1);
        if(root2 != null) getElems(ans2,root2);
        int i1 = 0; 
        int i2 = 0;
        while(i1 < ans1.size() && i2 < ans2.size()){
            if(ans1.get(i1) < ans2.get(i2)){
                res.add(ans1.get(i1));
                i1++;
            }
            else{
                res.add(ans2.get(i2));
                i2++;
            }                
        }
    if(i1 != ans1.size()){
        for(int i = i1 ; i < ans1.size(); i++){
            res.add(ans1.get(i));
        }
    }else if(i2 != ans2.size()){
         for(int i = i2 ; i < ans2.size(); i++){
            res.add(ans2.get(i));
        }
    }
    return res;
}

private void getElems(List<Integer> ans, TreeNode root){
    if(root.left == null && root.right == null){
        ans.add(root.val);
        return;
    }
    if(root.left != null) getElems(ans,root.left);
    ans.add(root.val);
    if(root.right != null) getElems(ans,root.right);
}
}
