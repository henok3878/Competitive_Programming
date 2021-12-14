package leet_code.java;

public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int rightSubTreeSum = 0;
        int leftSubTreeSum = 0;
        int currentNodeValue = 0;
        if(root.val < high){ // you can explore to the right 
            rightSubTreeSum = rangeSumBST(root.right, low, high);
        }
        if(root.val > low){// you can explore to the left 
           leftSubTreeSum = rangeSumBST(root.left, low, high);
           
        }
        if(root.val <= high && root.val >= low){
            currentNodeValue = root.val;
        }
        return currentNodeValue + rightSubTreeSum + leftSubTreeSum;
    }


    public static void main(String[] args){


        RangeSumofBST rangeSumofBST = new RangeSumofBST();
        // [10,5,15,3,7,null,18], low = 7, high = 15
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        root.right = new TreeNode(15, null, new TreeNode(18));
        int low = 7;
        int high = 15;

        int result = rangeSumofBST.rangeSumBST(root, low, high);
        System.out.println("result : " + result);
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