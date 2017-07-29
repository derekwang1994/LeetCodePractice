// Given a singly linked list L: L0?L1?…?Ln-1?Ln, reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
// You must do this in-place without altering the nodes' values.
// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.

public class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next == null) return;

        // cut the list into two from the middle node//
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        // call the reverse function to reverse the second list //
        ListNode head2 = reverseList(fast);

        // call the merge function to merge two lists back to one //
        merge(head, head2);

    }

    private ListNode reverseList(ListNode head){
        ListNode last = null;
        ListNode cur = head;

        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }

        return last;
    }

    private void merge(ListNode l1, ListNode l2) {

      while (l1 != null && l2 !=null) {
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;

        l1.next = l2;
        l2.next = n1;

        l1 = n1;
        l2 = n2;
      }

    }
}
