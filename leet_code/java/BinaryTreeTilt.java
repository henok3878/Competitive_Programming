package leet_code.java;

public class BinaryTreeTilt {


    public int findTilt(TreeNode root) {
        return findTiltHelper(root)[0];
    }

    public int[] findTiltHelper(TreeNode node){
        if(node == null){
            int[] ans = {0,0};
            return ans;
        }
        else if(node.left == null && node.right == null){
            int[] ans = {0,node.val};
            return ans;
        }
        else if(node.left == null && node.right != null){
            int[] rightChildResult = findTiltHelper(node.right);
            int tilt = rightChildResult[0] + Math.abs(rightChildResult[1]);
            int[] ans = {tilt,rightChildResult[1] + node.val};
            return ans;

        }
        else if(node.right == null && node.left != null){
            int[] leftChildResult = findTiltHelper(node.left);
            int tilt = leftChildResult[0] + Math.abs(leftChildResult[1]);
            int[] ans = {tilt,leftChildResult[1] + node.val};
            return ans;

        }
        else{
            int[] leftChildResult = findTiltHelper(node.left);
            int[] rightChildResult = findTiltHelper(node.right);
            int tilt = leftChildResult[0] + rightChildResult[0] + Math.abs(leftChildResult[1] - rightChildResult[1]);
            int sum = leftChildResult[1] + rightChildResult[1] + node.val;
            int[] ans = {tilt,sum};
            return ans;
        }
      
    }


    public static void main(String[] args){
        // TreeNode root = new TreeNode(4,new TreeNode(2, new TreeNode(3),new TreeNode(5)),
        // new TreeNode(9,null,new TreeNode(7)));
        TreeNode root = new TreeNode(1,null,new TreeNode(2,null,null));

        BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
        int result = binaryTreeTilt.findTilt(root);
        System.out.println("Result : "+ result);
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
    
