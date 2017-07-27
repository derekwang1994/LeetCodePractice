// Sort a linked list in O(n log n) time using constant space complexity.

// here, we use MergeSort, which has O(nlogn) time complexity and O(n)

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        // create two ListNode to find the middle Node of the List.
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // the head of the right half of the List is slow.next.
        fast = slow.next;
        // cut the List to keep only the left half of the List.
        slow.next = null;

        // call recursion to divide the List into smaller lists.
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(fast);

        // merge two List into a Sorted List.
        return mergeSort(l1, l2);
    }

    private ListNode mergeSort(ListNode l1, ListNode l2){
        // using recursion to merge is so slow that, in this case, will cause runtime error
        // , as a result, here we use iteration to merge two list.

        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode temp = new ListNode(0);
        ListNode cur = temp;

        while(l1!=null && l2!=null){
        // compare two nodes value, add the smaller one to the tempList and move it forward.
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // add the rest of the other list to the tempList whenever one is finished.
        if(l1==null) cur.next = l2;
        if(l2==null) cur.next = l1;

        return temp.next;
    }
}
