package leet_code.java;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode node, ListNode end) {
        if (node == null || node == end) {
            return null;
        } else {
            ListNode mid = findMid(node, end);
            TreeNode left = helper(node, mid);
            TreeNode right = helper(mid.next, end);
            TreeNode treeNode = new TreeNode(mid.val, left, right);
            return treeNode;
        }
    }

    private ListNode findMid(ListNode head, ListNode end) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
