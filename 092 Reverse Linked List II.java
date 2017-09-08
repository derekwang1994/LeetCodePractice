// Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
// return 1->4->3->2->5->NULL.
//
// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for(int i=1; i<m; i++){
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for(int i=0; i<n-m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // 1->2->3->4->5->6 pre=1, start=2, then=3
        // 1->3->2->4->5->6 pre=1, start=2, then=4
        // 1->4->3->2->5->6 pre=1, start=2, then=5
        // 1->5->4->3->2->6 pre=1, start=2, then=6


        return dummy.next;
    }
}
