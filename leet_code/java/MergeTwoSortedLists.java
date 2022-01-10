package leet_code.java;

public class MergeTwoSortedLists {

    //Recursive solution

   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
        if(list1 == null){
             return list2;       
        }else if(list2 == null){
            return list1;
        }
        else{
            
            if(list1.val <= list2.val){
                ListNode res = mergeTwoLists(list1.next,list2);
                list1.next = res;
                return list1;
            }
            ListNode res= mergeTwoLists(list1,list2.next);
            list2.next = res;
            return list2;
        }
       
    }
}
