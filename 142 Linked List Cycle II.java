// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// A+B+N = 2A+2B
// N=A+B

public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                ListNode slow2 = head;
                // trace back to the start of the cycle.
                while(slow != slow2){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }

        return null;
    }
}
