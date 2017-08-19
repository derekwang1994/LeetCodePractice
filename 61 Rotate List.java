// Given a list, rotate the list to the right by k places, where k is non-negative.
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null){
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;

        int count = 0;
        while(fast.next !=null ){ //Get the total length
            count++;
            fast = fast.next;
        }

        for(int i=0; i<count - (k % count); i++){
            slow = slow.next;
        }

        fast.next = newHead.next;  // Make the List to a circular list
        newHead.next = slow.next;  // set the new head
        slow.next = null; 

        return newHead.next;
    }
}
