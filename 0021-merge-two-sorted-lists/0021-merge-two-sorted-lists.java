/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        // Traverse both lists and link nodes in sorted order
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // move tail forward
        }
        
        // Attach the remaining part (if any) from list1 or list2
        if(list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        
        // The merged list starts from dummy.next
        return dummy.next;
    }
}