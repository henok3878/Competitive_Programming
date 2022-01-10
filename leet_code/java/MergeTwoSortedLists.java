package leet_code.java;

public class MergeTwoSortedLists {

    //Iterative solution
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int val1 = Integer.MAX_VALUE;
        int val2 = Integer.MAX_VALUE;
        while(list1 != null || list2 != null){
            val1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            val2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            
            if(val1 <= val2){
                temp.next= list1;
                list1 = list1.next;
            }
            else{
                temp.next =  list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        return ans.next;
        
    }
}
